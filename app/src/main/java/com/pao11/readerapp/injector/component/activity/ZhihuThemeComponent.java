package com.pao11.readerapp.injector.component.activity;

import com.pao11.readerapp.injector.module.activity.ZhihuThemeModule;
import com.pao11.readerapp.injector.module.http.ZhihuHttpModule;
import com.pao11.readerapp.ui.activity.zhihu.ZhihuThemeActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by pao11 on 2017/4/8.
 */
@Singleton
@Component(modules = { ZhihuHttpModule.class,ZhihuThemeModule.class})
public interface ZhihuThemeComponent {
    void injectZhiHuTheme(ZhihuThemeActivity zhihuThemeActivity);
}
