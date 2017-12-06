package com.pao11.readerapp.injector.component.activity;

import com.pao11.readerapp.injector.module.http.DoubanHttpModule;
import com.pao11.readerapp.ui.activity.douban.MovieTopDetailActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by pao11 on 2017/4/8.
 */
@Singleton
@Component(modules = { DoubanHttpModule.class})
public interface MovieDetailComponent {
    void injectMovieDetail(MovieTopDetailActivity movieTopDetailActivity);
}
