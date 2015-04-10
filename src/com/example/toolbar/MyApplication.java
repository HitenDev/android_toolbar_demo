package com.example.toolbar;

import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;

import android.app.Application;
import android.content.Context;

public class MyApplication extends Application {
	private static int sWidthPix;//获取屏幕W分辨率
	@Override
	public void onCreate() {
		super.onCreate();
		sWidthPix = getResources().getDisplayMetrics().widthPixels;
		initImageLoader(this);
	}
	/**
	 * 初始化ImageLoader
	 * @param context
	 */
	 private static void initImageLoader(Context context) {
	        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(context)
	                .threadPriority(Thread.NORM_PRIORITY - 2)
	                .denyCacheImageMultipleSizesInMemory()
	                .diskCacheFileNameGenerator(new Md5FileNameGenerator())
	                .diskCacheSize(50 * 1024 * 1024) // 50 Mb
	                .diskCacheFileCount(300)
	                .tasksProcessingOrder(QueueProcessingType.LIFO)
	                .diskCacheExtraOptions(sWidthPix / 3, sWidthPix / 3, null)
	                .build();
	        ImageLoader.getInstance().init(config);
	    }
}
