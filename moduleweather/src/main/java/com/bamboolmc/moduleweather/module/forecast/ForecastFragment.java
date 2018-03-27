package com.bamboolmc.moduleweather.module.forecast;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.bamboolmc.library.BaseApplication;
import com.bamboolmc.library.base.BaseFragment;
import com.bamboolmc.library.utils.RouteUtils;
import com.bamboolmc.library.utils.ToastUtil;
import com.bamboolmc.library.widget.MultiStateView;
import com.bamboolmc.library.widget.refresh.OnRefreshListener;
import com.bamboolmc.library.widget.refresh.RefreshLayout;
import com.bamboolmc.moduleweather.R;
import com.bamboolmc.moduleweather.R2;
import com.bamboolmc.moduleweather.dagger.DaggerWeatherComponent;
import com.bamboolmc.moduleweather.db.City;
import com.bamboolmc.moduleweather.db.CityDao;
import com.bamboolmc.moduleweather.module.citylocation.CityLocationActivity;
import com.bamboolmc.moduleweather.util.GpsUtil;
import com.bamboolmc.moduleweather.util.TextUtil;
import com.bamboolmc.moduleweather.widget.AqiView;
import com.bamboolmc.moduleweather.widget.HourForeCastView;
import com.bamboolmc.moduleweather.widget.MyListView;
import com.bamboolmc.moduleweather.widget.SkyView;
import com.bamboolmc.moduleweather.widget.SunRiseView;
import com.bamboolmc.moduleweather.widget.WeekForecastView;
import com.bamboolmc.moduleweather.widget.WindmillView;
import com.hwangjr.rxbus.RxBus;
import com.hwangjr.rxbus.annotation.Subscribe;
import com.mylhyl.acp.Acp;
import com.mylhyl.acp.AcpListener;
import com.mylhyl.acp.AcpOptions;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * Created by limc on 18/3/9.
 */

@Route(path = RouteUtils.Weather_Fragment)
public class ForecastFragment extends BaseFragment<ForecastPresenter> implements ForecastContract.View, BDLocationListener {

    @BindView(R2.id.weather_sky)
    SkyView mSkyView;
    @BindView(R2.id.weather_city)
    TextView mCurrentAreaTv;
    @BindView(R2.id.weather_tv_updateTime)
    TextView mUpdateTimeTv;
    @BindView(R2.id.weather_tv_temp)
    TextView mRealTempTv;
    @BindView(R2.id.weather_tv_realfeel)
    TextView mWeatherAndFeelTemp;
    @BindView(R2.id.weather_tv_aqi)
    TextView mTvAqi;
    @BindView(R2.id.weather_week_forecast)
    WeekForecastView weekForeCastView;
    @BindView(R2.id.weather_hourforecast)
    HourForeCastView hourForeCastView;
    @BindView(R2.id.weather_wind_big)
    WindmillView windViewBig;
    @BindView(R2.id.weather_wind_small)
    WindmillView windViewSmall;
    @BindView(R2.id.weather_tv_winddire)
    TextView mWindDegreeTv;
    @BindView(R2.id.weather_tv_windspeed)
    TextView mWindLevelTv;
    @BindView(R2.id.weather_pb_humidity)
    ProgressBar progressBar;
    @BindView(R2.id.weather_tv_humidity)
    TextView mShiduTv;
    @BindView(R2.id.weather_view_aqi)
    AqiView mAqi;
    @BindView(R2.id.weather_tv_aqiquality)
    TextView mRealAqiTv;
    @BindView(R2.id.weather_tv_pm25)
    TextView mPm2_5Tv;
    @BindView(R2.id.weather_tv_pm10)
    TextView mPm10Tv;
    @BindView(R2.id.weather_tv_so2)
    TextView mSo2Tv;
    @BindView(R2.id.weather_tv_no2)
    TextView mNo2Tv;
    @BindView(R2.id.weather_ll_aqi)
    LinearLayout mLlAqi;
    @BindView(R2.id.weather_view_sunrise)
    SunRiseView mSunRiseView;
    @BindView(R2.id.weather_my_lv)
    MyListView mZhishuLv;
    @BindView(R2.id.weather_ll_livingIndex)
    LinearLayout mLlLivingIndex;
    @BindView(R2.id.content_mains)
    ScrollView contentMian;
    @BindView(R2.id.weather_tv_chengeCity)
    TextView mTVChangeCity;
    @BindView(R2.id.refresh)
    RefreshLayout mRefreshLayout;
    @BindView(R2.id.weather_multi)
    MultiStateView mMultiStateView;


    private CityDao cityDao;
    private String weatherID = "101190501";
    private boolean isInit = false;   //是否初始化完毕
    private boolean isVisible = false;
    private ZhiShuAdapter mZhiShuAdapter;
    private List<WeatherMZEntity.IndexesBean> zhishuList;
    private City mCity;
    private WeatherMZEntity mWeatherMZEntity;
    private GpsUtil gpsUtil;

    @Inject
    ForecastPresenter mPresenter;

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_weather_test;
    }

    @Override
    public void attachView() {
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
    }

    @Override
    public void setComponentInject() {
        DaggerWeatherComponent.builder()
                .build()
                .inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        isInit = true;
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void initView() {
        RxBus.get().register(this);
        cityDao = new CityDao(BaseApplication.getAppContext());
        mWeatherMZEntity = new WeatherMZEntity();
        //初始化风车
        mSunRiseView.setSunRiseDowmTime("05:00", "18:46");
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    if (null == windViewBig || null == windViewSmall) {
                        break;
                    } else {
                        windViewBig.refreshView();
                        windViewSmall.refreshView();
                    }
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        zhishuList = new ArrayList<>();
        mZhiShuAdapter = new ZhiShuAdapter(zhishuList, getActivity());
        mZhishuLv.setAdapter(mZhiShuAdapter);

        mTVChangeCity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), CityLocationActivity.class));
            }
        });
        mRefreshLayout.setEnabled(getEnableRefresh());
        mRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh() {
                Log.d("xxxxRefresh", " is on");
                initBaiduMap();
//                gpsUtil.start();
            }
        });
    }


    @Override
    protected void loadData() {
        if (!isInit) {
            return;
        }
        if (getUserVisibleHint()) {
            getWeatherData();
            isVisible = true;
        } else {
            if (isVisible) {
                refreshStop();
                isVisible = false;
            }
        }
    }

    protected void getWeatherData() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            //判断是否拥有权限
            if (getActivity().getApplicationContext().checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED
                    && getActivity().getApplicationContext().checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED
                    && getActivity().getApplicationContext().checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED
                    && getActivity().getApplicationContext().checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED
                    ) {
                initBaiduMap();
            } else {
                getPermissons();
            }
        } else {
            initBaiduMap();
        }
    }

    //获取定位信息
    @Override
    public void onReceiveLocation(BDLocation bdLocation) {


        if (null != bdLocation && bdLocation.getLocType() != BDLocation.TypeServerError) {
            Log.d("xxxx-aaa", bdLocation.getCity() + bdLocation.getDistrict());
            if (bdLocation.getCity() == "" ||
                    bdLocation.getCity() == null ||
                    bdLocation.getDistrict() == "" ||
                    bdLocation.getDistrict() == null) {
                refreshStop();//刷新停止
                startActivity(new Intent(getActivity(), CityLocationActivity.class));
            } else {
                String areaName = TextUtil.getFormatArea(bdLocation.getDistrict());
                String cityName = TextUtil.getFormatArea(bdLocation.getCity());
                Log.d("xxxx--add--", areaName + cityName);
                mCity = cityDao.getCityByCityAndArea(cityName, areaName);

                if (mCity == null) {
                    mCity = cityDao.getCityByCityAndArea(cityName, cityName);
                    if (mCity == null) {
                        //TODO 此处定位失败，跳转到页面选择页面
                        refreshStop();
                        startActivity(new Intent(getActivity(), CityLocationActivity.class));
                        return;
                    }
                }
                mPresenter.getWeatherForecast(mCity.getWeatherId());
            }
        } else {
            refreshStop();
            startActivity(new Intent(getActivity(), CityLocationActivity.class));
            return;
        }
        gpsUtil.stop();
    }

    @Override
    public void showWeatherForecast(WeatherMZEntity weatherMZEntity) {
        mWeatherMZEntity = weatherMZEntity;
        WeatherMZEntity.RealtimeBean realtime = mWeatherMZEntity.getRealtime();
        WeatherMZEntity.Pm25Bean pm25 = mWeatherMZEntity.getPm25();
        List<WeatherMZEntity.WeathersBean> weathers = mWeatherMZEntity.getWeathers();
        //24小时
        List<WeatherMZEntity.WeatherDetailsInfoBean.Weather24HoursDetailsInfosBean> weather24Hours
                = mWeatherMZEntity.getWeatherDetailsInfo().getWeather24HoursDetailsInfos();
        List<WeatherMZEntity.IndexesBean> zhishu = mWeatherMZEntity.getIndexes();

        mCurrentAreaTv.setText(mWeatherMZEntity.getCity() + "·" + mWeatherMZEntity.getProvinceName());

        mRealTempTv.setText(realtime.getTemp());

        mUpdateTimeTv.setText(
                String.format(getResources().getString(R.string.activity_home_refresh_time), realtime.getTime().split(" ")[1].substring(0, 5))
        );
        mWeatherAndFeelTemp.setText(
                String.format(getResources().getString(R.string.activity_home_type_and_real_feel_temp),
                        realtime.getWeather(), realtime.getwD() + realtime.getwS() + ""));
        mRealAqiTv.setText("空气" + pm25.getQuality() + " " + pm25.getAqi());
        //周报&&时报
        weekForeCastView.setForeCasts(weathers);
        hourForeCastView.setHourForeCasts(weather24Hours);
        //风速湿度
        windViewBig.setWindSpeedDegree(Integer.parseInt(realtime.getwS().replace("级", "")));
        windViewSmall.setWindSpeedDegree(Integer.parseInt(realtime.getwS().replace("级", "")));
        mWindDegreeTv.setText(realtime.getwD());
        mWindLevelTv.setText(realtime.getwS());
        progressBar.setProgress(Integer.parseInt(realtime.getsD()));
        mShiduTv.setText(realtime.getsD());
        //空气
        mAqi.setProgressAndLabel(Integer.parseInt(pm25.getAqi()), "空气" + pm25.getQuality());
        mPm2_5Tv.setText(pm25.getPm25() + " μg/m³");
        mPm10Tv.setText(pm25.getPm10() + " μg/m³");
        mSo2Tv.setText(pm25.getSo2() + " μg/m³");
        mNo2Tv.setText(pm25.getNo2() + " μg/m³");
        //日出-----暂无数据
        mSunRiseView.setSunRiseDowmTime(weathers.get(0).getSun_rise_time(), weathers.get(0).getSun_down_time());

        //指数
        zhishuList.clear();
        zhishuList.addAll(zhishu);
        mZhiShuAdapter.notifyDataSetChanged();
        contentMian.smoothScrollTo(0, 0);

        mSkyView.setWeather(realtime.getWeather());
        mRefreshLayout.setRefreshing(false);
        mMultiStateView.setState(MultiStateView.STATE_CONTENT);

    }

    private void refreshStop() {
        mRefreshLayout.setRefreshing(false);
    }


    @Override
    public void showContent() {
        if (mRefreshLayout.isRefreshing()) {
            mRefreshLayout.setRefreshing(false);
        }
    }

    @Override
    public void onStartRequest() {
        if (mMultiStateView.getState() != MultiStateView.STATE_CONTENT) {
            mMultiStateView.setState(MultiStateView.STATE_LOADING);
        } else {
            mRefreshLayout.setRefreshing(true);
        }

    }

    @Override
    public void showError() {
        if (mRefreshLayout.isRefreshing()) {
            mRefreshLayout.setRefreshing(false);
        }

        if (mMultiStateView.getState() != MultiStateView.STATE_CONTENT) {
            mMultiStateView.setState(MultiStateView.STATE_ERROR)
                    .setIcon(R.mipmap.ic_exception)
                    .setTitle(R.string.label_error_network_is_bad)
                    .setButton(R.string.label_click_button_to_retry, new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            loadData();
                        }
                    });
        } else {
            ToastUtil.showToast(R.string.label_error_network_is_bad);
        }

    }

    @Subscribe
    public void ExchangeCity(City mcity) {
        mPresenter.getWeatherForecast(mcity.getWeatherId());
    }

    private void initBaiduMap() {
        Log.d("xxxx---->", "baidumap  start ");
        gpsUtil = new GpsUtil(BaseApplication.getAppContext(), this);
        gpsUtil.start();
    }

    public void getPermissons() {
        Acp.getInstance(getActivity()).request(new AcpOptions.Builder()
                        .setPermissions(Manifest.permission.WRITE_EXTERNAL_STORAGE
                                , Manifest.permission.ACCESS_FINE_LOCATION
                                , Manifest.permission.ACCESS_COARSE_LOCATION
                        )
                        .build(),
                new AcpListener() {
                    @Override
                    public void onGranted() {
                        //权限被允许
                        loadData();
                    }

                    @Override
                    public void onDenied(List<String> permissions) {
                        //TODO 此处定位失败，跳转到页面选择页面
                        refreshStop();
//                        ToastUtils.showToast(getApplicationContext(), "相关权限被拒绝");
                        startActivity(new Intent(getActivity(), CityLocationActivity.class));
                    }
                });
    }

    protected boolean getEnableRefresh() {
        return mMultiStateView.getState() == MultiStateView.STATE_CONTENT
                || mMultiStateView.getState() == MultiStateView.STATE_EMPTY;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        isInit = false;
        isVisible = false;
        RxBus.get().unregister(this);
    }
}
