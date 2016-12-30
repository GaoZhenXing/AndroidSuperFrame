package com.jason.superframe.assembly.photo_browser;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.jason.superframe.R;

import java.util.List;

import uk.co.senab.photoview.PhotoViewAttacher;

public class ImageViewPagerActivity extends AppCompatActivity {


    ViewPager mViewPager;

    TextView mTvLocation;

    private List<String> mDatas;
    private int mLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_image_view_pager);
        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        mTvLocation = (TextView) findViewById(R.id.tvLocation);

        initData();
        initView();
        initListener();
    }

    private void initView() {
        mTvLocation.setText(String.format("%d/%d", mLocation, mDatas.size()));
        mViewPager.setAdapter(new ImagePagerAdapter());
        mViewPager.setCurrentItem(mLocation);
    }


    private void initListener() {
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                mTvLocation.setText(String.format("%d/%d", position + 1, mDatas.size()));
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void initData() {
        mDatas = getIntent().getStringArrayListExtra("datas");
        mLocation = getIntent().getIntExtra("location", 0);
    }

    class ImagePagerAdapter extends PagerAdapter {
        @Override
        public int getCount() {
            return mDatas.size();
        }

        @Override
        public View instantiateItem(ViewGroup container, final int position) {
            View parent = LayoutInflater.from(container.getContext()).inflate(R.layout.activity_image_detial, container, false);
            container.addView(parent);
            View downLoad = parent.findViewById(R.id.tvDownload);
            View loading = parent.findViewById(R.id.progressBar);
            downLoad.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    downloadImage(mDatas.get(position));
                }
            });
            downLoad.setTag(mDatas.get(position));
            ImageView imageView = (ImageView) parent.findViewById(R.id.imageView);
            displayImage(mDatas.get(position), imageView, loading, downLoad);
            return parent;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        void displayImage(final String model, final ImageView imageView, final View loading, final View download) {
            Glide.with(ImageViewPagerActivity.this)
                    .load(model)
                    .error(R.drawable.ic_picture_load_fail)
//                    .centerCrop()
//                    .thumbnail(0.5f)
                    .listener(
                            new RequestListener<String, GlideDrawable>() {
                                @Override
                                public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                                    return false;
                                }
                                @Override
                                public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                                    loading.setVisibility(View.GONE);
                                    download.setVisibility(View.VISIBLE);
                                    PhotoViewAttacher attacher = new PhotoViewAttacher(imageView);
                                    attacher.update();
                                    return false;
                                }
                            })
                    .into(imageView);
        }

    }

    private void downloadImage(String baseUrl) {
    }
}


