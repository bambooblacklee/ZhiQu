package com.bamboolmc.moduleweather.util;


import android.content.Context;
import android.util.Log;

import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;

/**
 * Created by limc on 18/3/12.
 */
public class GpsUtil {

    private LocationClient mLocationClient;
    private Context mContext =null;

    //初始化

    public GpsUtil(Context context, BDLocationListener locationListener) {
        mContext = context;
        try {
            mLocationClient = new LocationClient(mContext.getApplicationContext());
            mLocationClient.registerLocationListener(locationListener);
            initLocation();
            mLocationClient.start();
        }catch (Exception e){
            Log.e("GpsUtil error : ", e.getMessage(), e);
        }

    }

    private void initLocation(){
        LocationClientOption option = new LocationClientOption();
        option.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);//可选，默认高精度，设置定位模式，高精度，低功耗，仅设备
        option.setIsNeedAddress(true);//可选，设置是否需要地址信息，默认不需要
        option.setIgnoreKillProcess(false);//可选，默认true，定位SDK内部是一个SERVICE，并放到了独立进程，设置是否在stop的时候杀死这个进程，默认不杀死
        option.SetIgnoreCacheException(true);//可选，默认false，设置是否收集CRASH信息，默认收集
        option.setEnableSimulateGps(false);//可选，默认false，设置是否需要过滤gps仿真结果，默认需要
        mLocationClient.setLocOption(option);
    }

    public void start(){
        mLocationClient.start();
    }

    public void stop(){
        mLocationClient.stop();
    }
}
