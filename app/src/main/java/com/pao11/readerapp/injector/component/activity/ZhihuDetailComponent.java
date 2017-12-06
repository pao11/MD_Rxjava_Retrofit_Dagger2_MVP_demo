package com.pao11.readerapp.injector.component.activity;

import com.pao11.readerapp.injector.module.http.ZhihuHttpModule;
import com.pao11.readerapp.ui.activity.zhihu.ZhiHuDetailActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by pao11 on 2017/4/8.
 */
@Singleton
@Component(modules = { ZhihuHttpModule.class})
public interface ZhihuDetailComponent {
    void injectZhiHuDetail(ZhiHuDetailActivity zhiHuDetailActivity);
}
