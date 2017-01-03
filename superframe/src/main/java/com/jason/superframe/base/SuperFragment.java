package com.jason.superframe.base;

import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;

/**
 * @author JasonGao
 * @time 2016/12/27 14:31
 * @描述：
 */
public  class SuperFragment extends Fragment {
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

    /**
     * 默认自定义handler
     *
     * @param msg 消息
     */
    protected  void handler(Message msg){

    };

}
