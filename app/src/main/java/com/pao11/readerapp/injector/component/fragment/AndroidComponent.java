package com.pao11.readerapp.injector.component.fragment;

import com.pao11.readerapp.injector.module.fragment.AndroidModule;
import com.pao11.readerapp.injector.module.http.GankIoHttpModule;
import com.pao11.readerapp.ui.fragment.gank.AndroidFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by pao11 on 2017/4/8.
 */
@Singleton
@Component(modules = { GankIoHttpModule.class,AndroidModule.class})
public interface AndroidComponent {
    void injectAndroid(AndroidFragment androidFragment);
}
