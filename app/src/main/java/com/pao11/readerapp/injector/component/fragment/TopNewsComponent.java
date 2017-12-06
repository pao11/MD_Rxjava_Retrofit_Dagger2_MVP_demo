package com.pao11.readerapp.injector.component.fragment;

import com.pao11.readerapp.injector.module.fragment.TopNewsModule;
import com.pao11.readerapp.injector.module.http.TopNewsHttpModule;
import com.pao11.readerapp.ui.fragment.home.child.TopNewsFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by pao11 on 2017/4/8.
 */
@Singleton
@Component(modules = { TopNewsHttpModule.class,TopNewsModule.class})
public interface TopNewsComponent {
    void injectTopNews(TopNewsFragment topNewsFragment);
}
