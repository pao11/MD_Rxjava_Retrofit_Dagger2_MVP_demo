package com.pao11.readerapp.injector.component.fragment;

import com.pao11.readerapp.injector.module.fragment.WeChatModule;
import com.pao11.readerapp.injector.module.http.WeChatHttpModule;
import com.pao11.readerapp.ui.fragment.wechat.WeChatFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by pao11 on 2017/4/8.
 */
@Singleton
@Component(modules = { WeChatHttpModule.class,WeChatModule.class})
public interface WeChatComponent {
    void injectWeChat(WeChatFragment weChatFragment);
}
