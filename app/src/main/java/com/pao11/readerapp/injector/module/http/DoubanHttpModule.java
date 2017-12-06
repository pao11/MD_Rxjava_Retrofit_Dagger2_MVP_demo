package com.pao11.readerapp.injector.module.http;

import com.pao11.readerapp.http.service.DoubanService;
import com.pao11.readerapp.injector.qualifier.DoubanUrl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * Created by pao11 on 2017/4/8.
 */
@Module
public class DoubanHttpModule extends BaseHttpModule {

    @Singleton
    @Provides
    @DoubanUrl
    Retrofit provideDoubanRetrofit(Retrofit.Builder builder, OkHttpClient client) {
        return createRetrofit(builder, client, DoubanService.API_DOUBAN);
    }

    @Singleton
    @Provides
    DoubanService provideDoubanService(@DoubanUrl Retrofit retrofit) {
        return retrofit.create(DoubanService.class);
    }

}
