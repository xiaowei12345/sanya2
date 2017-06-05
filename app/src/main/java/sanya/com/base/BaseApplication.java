package sanya.com.base;

import android.app.Application;

import com.facebook.stetho.Stetho;


/**
 * 应用Application类
 *
 * @author 马克的贝壳
 * @data
 */

public class BaseApplication extends Application {

    private static BaseApplication mContext;



    // 单例模式中获取唯一的ExitApplication 实例
    public static BaseApplication getInstance() {
        return mContext;

    }



    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;

        Stetho.initializeWithDefaults(mContext);


    }








}
