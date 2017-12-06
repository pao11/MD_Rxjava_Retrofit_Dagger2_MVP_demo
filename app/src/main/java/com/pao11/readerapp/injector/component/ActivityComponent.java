package com.pao11.readerapp.injector.component;

import android.app.Activity;

import com.pao11.readerapp.injector.module.ActivityModule;
import com.pao11.readerapp.injector.scope.ActivityScope;

import dagger.Component;

/**
 * Created by pao11 on 2017/3/21.
 */
@ActivityScope
@Component(dependencies = AppComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
    Activity getActivity();
}
