package com.pao11.readerapp.injector.module.http;

import com.pao11.readerapp.injector.qualifier.TopNewsUrl;
import com.pao11.readerapp.http.service.TopNewsService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * Created by pao11 on 2017/4/8.
 */
@Module
public class TopNewsHttpModule extends BaseHttpModule {
    @Singleton
    @Provides
    @TopNewsUrl
    Retrofit provideTopNewsRetrofit(Retrofit.Builder builder, OkHttpClient client) {
        return createRetrofit(builder, client, TopNewsService.API_TOPNEWS);
    }

    @Singleton
    @Provides
    TopNewsService provideTopNewsService(@TopNewsUrl Retrofit retrofit) {
        return retrofit.create(TopNewsService.class);
    }

}
