package com.bamboolmc.moduleweather.module.citylocation;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.bamboolmc.library.base.BaseActivity;
import com.bamboolmc.moduleweather.R;
import com.bamboolmc.moduleweather.R2;
import com.bamboolmc.moduleweather.db.City;
import com.bamboolmc.moduleweather.db.CityDao;
import com.bamboolmc.moduleweather.db.DBManager;
import com.bamboolmc.moduleweather.db.LocateState;
import com.bamboolmc.moduleweather.util.GpsUtil;
import com.bamboolmc.moduleweather.util.TextUtil;
import com.bamboolmc.moduleweather.widget.SideLetterBar;
import com.hwangjr.rxbus.RxBus;
import com.mylhyl.acp.Acp;
import com.mylhyl.acp.AcpListener;
import com.mylhyl.acp.AcpOptions;

import java.util.List;

import butterknife.BindView;

public class CityLocationActivity extends BaseActivity implements BDLocationListener {

    @BindView(R2.id.et_search)
    EditText searchBox;
    @BindView(R2.id.iv_search_clear)
    ImageView clearBtn;
    @BindView(R2.id.lv_all_city)
    ListView mListView;
    @BindView(R2.id.tv_letter_overlay)
    TextView overlay;
    @BindView(R2.id.side_letter_bar)
    SideLetterBar mLetterBar;
    @BindView(R2.id.lv_search_result)
    ListView mResultListView;
    @BindView(R2.id.empty_view)
    LinearLayout emptyView;

    private CityListAdapter mCityAdapter;
    private ResultListAdapter mResultAdapter;
    private List<City> mAllCities;
    private DBManager dbManager;
    private Context mContext;
    private CityDao cityDao;
    private City mCity;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_city_location;
    }

    @Override
    protected void attachView() {
    }

    @Override
    protected void setComponentInject() {

    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        cityDao = new CityDao(getApplicationContext());
        mContext = this;

        mLetterBar.setOverlay(overlay);
        mLetterBar.setOnLetterChangedListener(new SideLetterBar.OnLetterChangedListener() {
            @Override
            public void onLetterChanged(String letter) {
                int position = mCityAdapter.getLetterPosition(letter);
                mListView.setSelection(position);
            }
        });

        mResultAdapter = new ResultListAdapter(this, null);
        mResultListView.setAdapter(mResultAdapter);
        mResultListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                back2(mResultAdapter.getItem(position).getName());
            }
        });

        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchBox.setText("");
                clearBtn.setVisibility(View.GONE);
                emptyView.setVisibility(View.GONE);
                mResultListView.setVisibility(View.GONE);
            }
        });
        searchBox.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                String keyword = s.toString();
                if (TextUtils.isEmpty(keyword)) {
                    clearBtn.setVisibility(View.GONE);
                    emptyView.setVisibility(View.GONE);
                    mResultListView.setVisibility(View.GONE);
                } else {
                    clearBtn.setVisibility(View.VISIBLE);
                    mResultListView.setVisibility(View.VISIBLE);
                    List<City> result = dbManager.searchCity(keyword);
                    if (result == null || result.size() == 0) {
                        emptyView.setVisibility(View.VISIBLE);
                    } else {
                        emptyView.setVisibility(View.GONE);
                        mResultAdapter.changeData(result);
                    }
                }
            }
        });
    }

    @Override
    protected void initData() {
        dbManager = new DBManager(this);
        dbManager.copyDBFile();
        mAllCities = dbManager.getAllCities();
        Log.d("xxxx--allcity",mAllCities.toString());
        mCityAdapter = new CityListAdapter(this, mAllCities);
        mListView.setAdapter(mCityAdapter);
        mCityAdapter.setOnCityClickListener(new CityListAdapter.OnCityClickListener() {
            @Override
            public void onCityClick(String name) {
                Log.d("xxxx--onCityClick", name);
                back(name);
            }

            @Override
            public void onLocateClick() {
                Log.d("xxxx--onLocateClick", "重新定位...");
                mCityAdapter.updateLocateState(LocateState.LOCATING, null);
                initParam();
            }

            @Override
            public void onSelected(String cityName) {
                Log.d("xxxx--onSelected", cityName);
                back(cityName);
            }
        });
        initLocation();
    }

    private void initLocation() {
        //开启6.0+全选
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            //判断是否拥有权限
            if (getApplicationContext().checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED
                    && getApplicationContext().checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED
                    && getApplicationContext().checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED
                    && getApplicationContext().checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED
                    ) {
                initParam();
            } else {
                getPerimissons();
            }
        } else {
            initParam();
        }
    }

    private void initParam() {
        GpsUtil gpsUtil = new GpsUtil(mContext, this);
        gpsUtil.start();
    }

    @Override
    public void onReceiveLocation(BDLocation bdLocation) {
        if (null != bdLocation && bdLocation.getLocType() != BDLocation.TypeServerError) {
            String areaName = TextUtil.getFormatArea(bdLocation.getDistrict());
            String cityName = TextUtil.getFormatArea(bdLocation.getCity());
            String location = TextUtil.getFormatArea(areaName);
            mCityAdapter.updateLocateState(LocateState.SUCCESS, areaName);
        } else if (bdLocation.getLocType() == BDLocation.TypeServerError
                || bdLocation.getLocType() == BDLocation.TypeNetWorkException
                || bdLocation.getLocType() == BDLocation.TypeCriteriaException) {
            //定位失败
            mCityAdapter.updateLocateState(LocateState.FAILED, null);
        }

    }

    private void back(String city) {
        mCity = cityDao.getCityArea(city);
        if (mCity == null) {
            mCity = cityDao.getCityByCityAndArea(city, city);
            if (mCity == null) {
                //定位失败
                mCityAdapter.updateLocateState(LocateState.FAILED, null);
                return;
            }
        }
        RxBus.get().post(mCity);
        finish();
    }

    private void back2(String city) {
        mCity = cityDao.getCityArea(city);
        if (mCity == null) {
            mCity = cityDao.getCityByCityAndArea(city, city);
            if (mCity == null) {
                Toast.makeText(mContext, "尚未有该城市的天气记录", Toast.LENGTH_SHORT).show();
                return;
            }
        }
        RxBus.get().post(mCity);
        finish();
    }

    public void getPerimissons() {
        Acp.getInstance(this).request(new AcpOptions.Builder()
                        .setPermissions(Manifest.permission.WRITE_EXTERNAL_STORAGE
                                , Manifest.permission.ACCESS_FINE_LOCATION
                                , Manifest.permission.ACCESS_COARSE_LOCATION
                        )
                        .build(),
                new AcpListener() {
                    @Override
                    public void onGranted() {
                        //权限被允许
                        initParam();
                    }

                    @Override
                    public void onDenied(List<String> permissions) {
                        //TODO 此处定位失败，默认上海
                        back("北京");
//                        ToastUtils.showToast(getApplicationContext(), "相关权限被拒绝");
                    }
                });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
