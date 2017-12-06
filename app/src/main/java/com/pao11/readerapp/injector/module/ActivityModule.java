package com.pao11.readerapp.injector.module;

import android.app.Activity;

import com.pao11.readerapp.injector.scope.ActivityScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by pao11 on 2017/3/21.
 */

@Module
public class ActivityModule {
    private Activity mActivity;

    public ActivityModule(Activity activity) {
        this.mActivity = activity;
    }

    @Provides
    @ActivityScope
    public Activity provideActivity() {
        return mActivity;
    }

}
