package com.jason.androidsuperframe;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.jason.superframe.base.SuperFragment;

import java.util.ArrayList;

/**
 * 项目名称：AndroidSuperFrame
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 * 创建人：JasonGao
 * 创建日期：2017/1/4.10:28
 */

public class MainFragmentPagerAdapter extends FragmentPagerAdapter {
    private ArrayList<SuperFragment> mFragments;

    public MainFragmentPagerAdapter(FragmentManager fm, ArrayList fragments) {
        super(fm);
        this.mFragments = fragments;
    }



    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments == null ? 0 : mFragments.size();
    }
}
