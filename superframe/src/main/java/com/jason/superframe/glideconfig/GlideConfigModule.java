package com.jason.superframe.glideconfig;

import android.content.Context;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool;
import com.bumptech.glide.load.engine.cache.InternalCacheDiskCacheFactory;
import com.bumptech.glide.load.engine.cache.LruResourceCache;
import com.bumptech.glide.module.GlideModule;
import com.bumptech.glide.request.target.ViewTarget;
import com.jason.superframe.R;

/**
 * 项目名称：superFrame
 * 〈配置glide〉
 * 〈修改缓存大小、位置、加载图片质量〉
 * 创建人：JasonGao
 * 创建日期：2016/12/29.10:19
 */

public class GlideConfigModule implements GlideModule {


    @Override
    public void registerComponents(Context context, Glide glide) {
    }

    @Override
    public void applyOptions(Context context, GlideBuilder builder) {
        //全局设置ViewTaget的tagId:
        ViewTarget.setTagId(R.id.glide_tag_id);
        // 指定位置在packageName/cache/glide_cache,大小为MAX_CACHE_DISK_SIZE的磁盘缓存
        builder.setDiskCache(new InternalCacheDiskCacheFactory(context, "glide_cache", ConfigConstants.MAX_CACHE_DISK_SIZE));
        //指定内存缓存大小
        builder.setMemoryCache(new LruResourceCache(ConfigConstants.MAX_CACHE_MEMORY_SIZE));
        //全部的内存缓存用来作为图片缓存
        builder.setBitmapPool(new LruBitmapPool(ConfigConstants.MAX_CACHE_MEMORY_SIZE));
        builder.setDecodeFormat(DecodeFormat.DEFAULT);

    }
}