package com.jason.androidsuperframe;

import android.os.Bundle;
import android.os.Message;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.apkfuns.logutils.LogUtils;
import com.jaeger.library.StatusBarUtil;
import com.jason.androidsuperframe.fragments.HTTPFragment;
import com.jason.androidsuperframe.fragments.PermissionFragment;
import com.jason.androidsuperframe.fragments.RecoveryViewFragment;
import com.jason.superframe.base.SuperActivity;
import com.jason.superframe.base.SuperFragment;

import java.util.ArrayList;

import me.majiajie.pagerbottomtabstrip.Controller;
import me.majiajie.pagerbottomtabstrip.PagerBottomTabLayout;
import me.majiajie.pagerbottomtabstrip.TabLayoutMode;
import me.majiajie.pagerbottomtabstrip.listener.OnTabItemSelectListener;


public class MainActivity extends SuperActivity implements NavigationView.OnNavigationItemSelectedListener, ViewPager.OnPageChangeListener {
    private Fragment mCurrentFragment;
    Controller controller;
    private ViewPager mViewPager;
    private PagerBottomTabLayout mTab;
    private ArrayList<SuperFragment> mFragments;
    private DrawerLayout drawer;
    private MainFragmentPagerAdapter mFragmentPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        mTab = (PagerBottomTabLayout) findViewById(R.id.tab);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        BottomTabTest();
        initFragment();
        mFragmentPagerAdapter = new MainFragmentPagerAdapter(getSupportFragmentManager(), mFragments);
        mViewPager.setAdapter(mFragmentPagerAdapter);
        mViewPager.addOnPageChangeListener(this);
    }

    private void initFragment() {
        mFragments = new ArrayList<>();
        mFragments.add(new RecoveryViewFragment());
        mFragments.add(new PermissionFragment());
        mFragments.add(new HTTPFragment());
    }

    @Override
    protected void setStatusBar() {
        StatusBarUtil.setColorForDrawerLayout(this,
                (DrawerLayout) findViewById(R.id.drawer_layout),
                getResources().getColor(R.color.colorPrimary),
                0);
    }

    private void BottomTabTest() {
        PagerBottomTabLayout pagerBottomTabLayout = (PagerBottomTabLayout) findViewById(R.id.tab);


        //构建导航栏,得到Controller进行后续控制
        controller = pagerBottomTabLayout.builder()
                .addTabItem(R.mipmap.ic_main_tab_1, "音乐", 0xff008FCB)
                .addTabItem(R.mipmap.ic_main_tab_3, "鸡年大吉", 0xff008FCB)
                .addTabItem(R.mipmap.ic_main_tab_2, "喜爱", 0xff008FCB)
                .setMode(TabLayoutMode.HIDE_TEXT)//底部标题栏样式
                .setMode(TabLayoutMode.CHANGE_BACKGROUND_COLOR)
                .build();


        controller.addTabItemClickListener(listener);
    }

    @Override
    protected void handler(Message msg) {

    }

    OnTabItemSelectListener listener = new OnTabItemSelectListener() {
        @Override
        public void onSelected(int index, Object tag) {
            mViewPager.setCurrentItem(index);
            if (getSupportActionBar() != null)
            {
                getSupportActionBar().setTitle(index == 0 ? "音乐" : index == 1 ? "鸡年大吉" : index == 2 ? "喜爱" : "SuperStart");
            }
            LogUtils.d("index" + index);
        }

        @Override
        public void onRepeatClick(int index, Object tag) {

        }
    };

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_camera) {

        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }



    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        controller.setSelect(position);
        LogUtils.d("position" + position);

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }


    public void switchContent(Fragment to) {
        if (mCurrentFragment != to) {
            FragmentTransaction transaction = getSupportFragmentManager()
                    .beginTransaction();
            if (!to.isAdded()) { // 先判断是否被add过
                transaction.hide(mCurrentFragment).add(0, to).commit(); // 隐藏当前的fragment，add下一个到Activity中
            } else {
                transaction.hide(mCurrentFragment).show(to).commit(); // 隐藏当前的fragment，显示下一个
            }
            mCurrentFragment = to;
        }
    }
}
