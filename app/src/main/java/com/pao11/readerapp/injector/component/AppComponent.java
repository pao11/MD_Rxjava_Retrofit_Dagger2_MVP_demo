package com.pao11.readerapp.injector.component;

import com.pao11.readerapp.app.App;
import com.pao11.readerapp.injector.module.AppModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by pao11 on 2017/3/21.
 */
@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {
    App getContext();  // 提供App的Context

}
