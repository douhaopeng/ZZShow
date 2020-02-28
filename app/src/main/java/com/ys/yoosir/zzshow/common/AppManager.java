package com.ys.yoosir.zzshow.common;

import android.app.Application;

import com.ys.yoosir.zzshow.events.AppManagerEvent;
import com.ys.yoosir.zzshow.utils.RxBus;

import java.util.List;

import rx.Subscription;
import rx.functions.Action1;

/**
 * Created by 窦浩鹏 on 2020/2/28.
 */

public class AppManager {

    protected  final String APP_MANAGER_MESSAGE = "app_manager_message";
    public static final int START_ACTIVITY = 0;
    public static final int SHOW_SNACKBAR = 0;
    public static final int KILL_ALL = 2;
    public static final int APP_EXIT = 3;
    Subscription mSubscription;
    private Application mApplication;
    //管理所有activity
    public List<BaseActivity> mActivityList;
    //当前在前台的activity
    private BaseActivity mCurrentActivity;

    public AppManager(Application application){
        this.mApplication = application;
        mSubscription = RxBus.getInstance().toObservable(AppManagerEvent.class)
                .subscribe(new Action1<AppManagerEvent>() {
                    @Override
                    public void call(AppManagerEvent managerEvent) {
                        switch (managerEvent.getType()){
                            case START_ACTIVITY:
                                break;
                            case SHOW_SNACKBAR:
                                break;
                            case KILL_ALL:
                                break;
                            case APP_EXIT:
                                break;
                        }
                    }
                });
    }


    //释放资源
    public void release(){
        if(mSubscription!= null && mSubscription.isUnsubscribed()){
            mSubscription.unsubscribe();
            mSubscription = null;
        }
        mActivityList.clear();
        mActivityList = null;
        mCurrentActivity = null;
        mApplication = null;
    }

    /**
     * 将在前台的activity保存
     * @param currentActivity
     */

    public void setmCurrentActivity(BaseActivity currentActivity){
        this.mCurrentActivity = currentActivity;
    }

}
