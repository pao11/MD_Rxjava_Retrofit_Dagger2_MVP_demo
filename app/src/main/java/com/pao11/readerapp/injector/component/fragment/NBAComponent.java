package com.pao11.readerapp.injector.component.fragment;

import com.pao11.readerapp.injector.module.fragment.NBAModule;
import com.pao11.readerapp.injector.module.http.TopNewsHttpModule;
import com.pao11.readerapp.ui.fragment.wechat.NBAFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by pao11 on 2017/4/8.
 */
@Singleton
@Component(modules = { TopNewsHttpModule.class,NBAModule.class})
public interface NBAComponent {
    void injectNBA(NBAFragment nbaFragment);
}
