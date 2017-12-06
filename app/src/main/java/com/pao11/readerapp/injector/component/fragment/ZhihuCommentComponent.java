package com.pao11.readerapp.injector.component.fragment;

import com.pao11.readerapp.injector.module.fragment.ZhihuCommentModule;
import com.pao11.readerapp.injector.module.http.ZhihuHttpModule;
import com.pao11.readerapp.ui.fragment.home.child.zhihu.ZhiHuCommentFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by pao11 on 2017/4/8.
 */
@Singleton
@Component(modules = { ZhihuHttpModule.class,ZhihuCommentModule.class})
public interface ZhihuCommentComponent {
    void injectZhihuComment(ZhiHuCommentFragment zhiHuCommentFragment);
}
