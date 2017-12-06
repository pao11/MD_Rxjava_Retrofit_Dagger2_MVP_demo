package com.pao11.readerapp.injector.module.activity;

import com.pao11.readerapp.adapter.ZhihuThemeAdapter;

import java.util.ArrayList;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by pao11 on 2017/4/8.
 */
@Module
public class ZhihuThemeModule {
    @Provides
    @Singleton
    public ZhihuThemeAdapter provideAdapter() {
        return new ZhihuThemeAdapter(new ArrayList());
    }
}
