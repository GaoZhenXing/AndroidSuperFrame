package com.jason.superframe.base;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.jason.superframe.constant.Constants;
import com.jason.superframe.utils.ActivitiesManager;
import com.jason.superframe.utils.NetUtil;

/**
 * 项目名称：SuperFrame
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 * 创建人：JasonGao
 * 创建日期： 2016年12月27日 14:55
 */

public abstract class SuperActivity extends AppCompatActivity {

    BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            // 处理各种情况
            String action = intent.getAction();
            if (Constants.ACTION_NETWORK_CHANGE.equals(action)) { // 网络发生变化
                // 处理网络问题
                int networkState = NetUtil.getNetworkState(context);
                switch (networkState) {
                    case NetUtil.NETWORN_NONE://无网络

                        break;
                    case NetUtil.NETWORN_MOBILE://移动网络

                        break;
                    case NetUtil.NETWORN_WIFI://wifi

                        break;
                }

            } else if (Constants.ACTION_PUSH_DATA.equals(action)) { // 可能有新数据

            } else if (Constants.ACTION_NEW_VERSION.equals(action)) { // 可能发现新版本
                // VersionDialog 可能是版本提示是否需要下载的对话框
            }
        }
    };
    /**
     * 父类的handler
     */
    protected Handler mHandler = new Handler(
    ) {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            handler(msg);//交给子类处理
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivitiesManager.getInstance().addActivity(this);
//        StatusBarUtil.setColor(this,0xFF0000 );
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivitiesManager.getInstance().removeActivity(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        // 你可以添加多个Action捕获
        IntentFilter filter = new IntentFilter();
        filter.addAction(Constants.ACTION_NETWORK_CHANGE);
        filter.addAction(Constants.ACTION_PUSH_DATA);
        filter.addAction(Constants.ACTION_NEW_VERSION);
        registerReceiver(receiver, filter);
        //还可能发送统计数据，比如第三方的SDK 做统计需求
    }

    /**
     * 默认自定义handler
     *
     * @param msg 消息
     */
    protected abstract void handler(Message msg);




}
