package com.jason.superframe.base;

import android.app.Application;

import com.apkfuns.logutils.LogLevel;
import com.apkfuns.logutils.LogUtils;
import com.jason.superframe.utils.ActivitiesManager;
import com.jason.superframe.utils.ErrerCrashHandler;

public class SuperApplication extends Application {
    private final String LOG_TAG = "SuperApplication";

    @Override
    public void onCreate() {
        ErrerCrashHandler.getInstance();//打印错误日志
        //logUtils注册
        LogUtils.getLogConfig()
                .configAllowLog(true)
                .configTagPrefix(LOG_TAG)
                .configShowBorders(false)
                .configFormatTag("%d{HH:mm:ss:SSS} %t %c{-2}")
                .configLevel(LogLevel.TYPE_VERBOSE);
        super.onCreate();
    }

}
