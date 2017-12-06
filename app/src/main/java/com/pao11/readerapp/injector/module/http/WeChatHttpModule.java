package com.pao11.readerapp.injector.module.http;

import com.pao11.readerapp.injector.qualifier.WeChatUrl;
import com.pao11.readerapp.http.service.WeChatService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * Created by pao11 on 2017/4/8.
 */
@Module
public class WeChatHttpModule extends BaseHttpModule {
    @Singleton
    @Provides
    @WeChatUrl
    Retrofit provideWeChatRetrofit(Retrofit.Builder builder, OkHttpClient client) {
        return createRetrofit(builder, client, WeChatService.API_WeChat);
    }

    @Singleton
    @Provides
    WeChatService provideWeChatService(@WeChatUrl Retrofit retrofit) {
        return retrofit.create(WeChatService.class);
    }

}
