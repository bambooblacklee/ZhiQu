package com.bamboolmc.zhiqu.util;

import com.bamboolmc.library.BaseApplication;

public class StringFetcher {

    public static String getString(int id) {
        return BaseApplication.getAppContext().getString(id);
    }

    public static String getString(int id, Object... format) {
        return BaseApplication.getAppContext().getString(id, format);
    }

}