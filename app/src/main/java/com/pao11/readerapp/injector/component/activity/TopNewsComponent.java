package com.pao11.readerapp.injector.component.activity;

import com.pao11.readerapp.injector.module.http.TopNewsHttpModule;
import com.pao11.readerapp.ui.activity.topnews.NBAActivity;
import com.pao11.readerapp.ui.activity.topnews.TopNewsActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by pao11 on 2017/4/8.
 */
@Singleton
@Component(modules = { TopNewsHttpModule.class})
public interface TopNewsComponent {
    void injectTopNews(TopNewsActivity topNewsActivity);
    void injectNBA(NBAActivity nbaActivity);
}
