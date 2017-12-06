package com.pao11.readerapp.injector.module.http;

import com.pao11.readerapp.http.service.GankIoService;
import com.pao11.readerapp.injector.qualifier.GankUrl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * Created by pao11 on 2017/4/8.
 */
@Module
public class GankIoHttpModule extends BaseHttpModule {
    @Singleton
    @Provides
    @GankUrl
    Retrofit provideGankIoRetrofit(Retrofit.Builder builder, OkHttpClient client) {
        return createRetrofit(builder, client, GankIoService.API_GANKIO);
    }

    @Singleton
    @Provides
    GankIoService provideGankIoService(@GankUrl Retrofit retrofit) {
        return retrofit.create(GankIoService.class);
    }


}
