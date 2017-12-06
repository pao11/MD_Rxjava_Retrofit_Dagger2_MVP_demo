package com.pao11.readerapp.injector.component.fragment;

import com.pao11.readerapp.injector.module.fragment.DoubanMovieLatestModule;
import com.pao11.readerapp.injector.module.http.DoubanHttpModule;
import com.pao11.readerapp.ui.fragment.home.child.DouBanMovieLatestFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by pao11 on 2017/4/8.
 */
@Singleton
@Component(modules = { DoubanHttpModule.class,DoubanMovieLatestModule.class})
public interface DoubanMovieLatestComponent {
    void injectDoubanMovieLatest(DouBanMovieLatestFragment douBanMovieLatestFragment);
}
