package com.jason.superframe.utils;

import android.app.Activity;

import java.util.Stack;

/**
 * 项目名称：AndroidSuperFrame
 * 〈activity管理类〉
 * 〈完全退出应用〉
 * 创建人：JasonGao
 * 创建日期：2016/12/28.17:16
 */

public class ActivitiesManager {
    private Stack<Activity> activityStack = new Stack<Activity>();//Activity堆
    private static ActivitiesManager instance = new ActivitiesManager();

    public static ActivitiesManager getInstance() {
        return instance;
    }

    private ActivitiesManager() {
    }

    /**
     * 添加Activity
     *
     * @param activity
     */
    public void addActivity(Activity activity) {
        if (null == activityStack) {
            activityStack = new Stack<Activity>();
        }
        activityStack.add(activity);
    }

    public void removeActivity(Activity curAT) {
        if (null == activityStack) {
            activityStack = new Stack<Activity>();
        }
        activityStack.remove(curAT);
    }

    //获取最后一个Activity
    public Activity currentActivity() {
        Activity activity = activityStack.lastElement();
        return activity;
    }

    //返回寨内Activity的总数
    public int howManyActivities() {
        return activityStack.size();
    }

    //关闭所有Activity
    public void finishAllActivities() {
        for (int i = 0, size = activityStack.size(); i < size; i++) {
            if (null != activityStack.get(i)) {
                activityStack.get(i).finish();
            }
        }
        activityStack.clear();
    }
}
