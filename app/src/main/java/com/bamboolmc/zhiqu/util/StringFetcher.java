package com.bamboolmc.zhiqu.util;

import com.bamboolmc.zhiqu.ZhiQuApplication;

public class StringFetcher {

    public static String getString(int id) {
        return ZhiQuApplication.getContext().getString(id);
    }

    public static String getString(int id, Object... format) {
        return ZhiQuApplication.getContext().getString(id, format);
    }

}