package com.cuipengyu.rvitemsideskidremoveutil;

import android.app.Application;
import android.content.Context;


/**
 * App全局对象 ,manifest中声明name
 * Created by cuipengyu on 2018/3/14.
 */

public class ApplicationContextUtil extends Application {
    private static ApplicationContextUtil mApplicationContext;


    public static Context getAppConnect() {
        return mApplicationContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mApplicationContext = this;

    }

}
