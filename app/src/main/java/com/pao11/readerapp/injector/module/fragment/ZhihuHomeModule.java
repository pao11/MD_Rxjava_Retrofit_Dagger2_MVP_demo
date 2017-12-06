package com.pao11.readerapp.injector.module.fragment;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.pao11.readerapp.adapter.ZhiHuAdapter;
import com.pao11.readerapp.bean.zhihu.HomeListBean;

import java.util.ArrayList;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by pao11 on 2017/4/8.
 */
@Module
public class ZhihuHomeModule {
    @Provides
    @Singleton
    public BaseQuickAdapter provideAdapter() {
        return new ZhiHuAdapter(new ArrayList<HomeListBean>());//new ArrayList()这样子也可以，不过这里我们为了给自己看就写了泛型。
    }
}
