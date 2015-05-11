package com.xwj.customview.Component;

import android.app.Application;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

/**
 * Created by user on 2015/4/10.
 */
public class DreamCustomViewApplication extends Application {
    private DreamCustomViewApplication mDreamCustomViewApplication = null;

    public DreamCustomViewApplication() {
    }

    public synchronized  DreamCustomViewApplication getInstace(){
        if (mDreamCustomViewApplication == null)
            mDreamCustomViewApplication = new DreamCustomViewApplication();
        return  mDreamCustomViewApplication;
    }

    @Override
    public void onCreate() {
        //应用程序启动时被系统调用
        initImageLoader();
    }

    private void initImageLoader() {
        ImageLoaderConfiguration imageLoaderConfiguration = ImageLoaderConfiguration.createDefault(this);
        ImageLoader.getInstance().init(imageLoaderConfiguration);
    }

    @Override
    public void onTerminate() {
        //应用程序退出时会被系统调用
    }


}
