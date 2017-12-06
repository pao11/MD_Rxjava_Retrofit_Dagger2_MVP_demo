package com.pao11.readerapp.injector.component.fragment;

import com.pao11.readerapp.injector.module.fragment.ZhihuHomeModule;
import com.pao11.readerapp.injector.module.http.ZhihuHttpModule;
import com.pao11.readerapp.ui.fragment.home.child.zhihu.ZhiHuHomeFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by pao11 on 2017/4/8.
 */
@Singleton
@Component(modules = { ZhihuHttpModule.class,ZhihuHomeModule.class})
public interface ZhihuHomeComponent {
    void injectZhihuhome(ZhiHuHomeFragment zhiHuFragment);
}
