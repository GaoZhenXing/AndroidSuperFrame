package com.jason.superframe.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * 项目名称：SuperFrame
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 * 创建人：JasonGao
 * 创建日期： 2016年12月27日 14:55
 */

public class SuperActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SuperApplication.activitiesManager.addActivity(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SuperApplication.activitiesManager.removeActivity(this);
    }
}
