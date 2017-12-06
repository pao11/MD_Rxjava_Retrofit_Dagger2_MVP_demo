package com.pao11.readerapp.injector.component.fragment;

import com.pao11.readerapp.injector.module.fragment.DoubanMovieTopModule;
import com.pao11.readerapp.injector.module.http.DoubanHttpModule;
import com.pao11.readerapp.ui.fragment.home.child.DouBanMovieTopFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by pao11 on 2017/4/8.
 */
@Singleton
@Component(modules = { DoubanHttpModule.class,DoubanMovieTopModule.class})
public interface DoubanMovieTopComponent {
    void injectDoubanMovieTop(DouBanMovieTopFragment douBanMovieTopFragment);
}
