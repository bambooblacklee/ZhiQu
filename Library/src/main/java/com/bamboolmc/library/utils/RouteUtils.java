package com.bamboolmc.library.utils;

import android.support.v4.app.Fragment;
import com.alibaba.android.arouter.launcher.ARouter;

/**
 * Created by limc on 18/2/28.
 */
public class RouteUtils {
    //App模块
    public static final String App_Fragment_MtMovie ="/app/mtMovieFragment";


    //News 模块
    public static final String News_Activity_Detail ="/news/detailActivity";
    public static final String News_Activity_Special ="/news/specialActivity";
    public static final String News_Fragment_News ="/news/newsFragment";
    public static final String News_Fragment_Test ="/news/newsTestFragment";

    //Video 模块
    public static final String Video_Activity_Detail ="/video/detailActivity";
    public static final String Video_Activity_Topic ="/video/topicActivity";
    public static final String Video_Fragment_Video ="/video/videoFragment";

    //测试Login模块
    public static final String News_Activity_Login ="/news/loginActivity";

    //Weather模块
    public static final String Weather_Fragment ="/weather/forecastFragment";
    public static final String Weather_Activity ="/weather/weatherActivity";


    public static Fragment getWeatherFragment (){
        Fragment weatherFragment =(Fragment) ARouter.getInstance().build(Weather_Fragment).navigation();
        return weatherFragment;
    }


    public static Fragment getNewsFragment (){
        Fragment newsFragment =(Fragment) ARouter.getInstance().build(News_Fragment_News).navigation();
        return newsFragment;
    }

    public static Fragment getVideoFragment (){
        Fragment videoFragment =(Fragment) ARouter.getInstance().build(Video_Fragment_Video).navigation();
        return videoFragment;
    }

    public static Fragment getAppMtVideoFragment (){
        Fragment mtMovieFragment =(Fragment) ARouter.getInstance().build(App_Fragment_MtMovie).navigation();
        return mtMovieFragment;
    }

    public static Fragment getNewsTestFragment (){
        Fragment mTestFragment =(Fragment) ARouter.getInstance().build(News_Fragment_Test).navigation();
        return mTestFragment;
    }
}
