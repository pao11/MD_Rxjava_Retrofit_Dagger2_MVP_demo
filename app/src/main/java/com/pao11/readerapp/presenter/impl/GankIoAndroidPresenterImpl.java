package com.pao11.readerapp.presenter.impl;

import com.pao11.readerapp.bean.gankio.GankIoDataBean;
import com.pao11.readerapp.http.service.GankIoService;
import com.pao11.readerapp.http.utils.Callback;
import com.pao11.readerapp.presenter.BasePresenter;
import com.pao11.readerapp.presenter.GankIoAndroidPresenter;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by pao11 on 2017/3/30.
 */

public class GankIoAndroidPresenterImpl extends BasePresenter<GankIoAndroidPresenter.View> implements GankIoAndroidPresenter.Presenter {
    private GankIoService mGankIoService;

    @Inject
    public GankIoAndroidPresenterImpl(GankIoService mGankIoService) {
        this.mGankIoService = mGankIoService;
    }


    @Override
    public void fetchGankIoData(int page, int pre_page) {
        invoke(mGankIoService.getGankIoData("Android",page,pre_page),new Callback<GankIoDataBean>(){
            @Override
            public void onResponse(GankIoDataBean data) {
                List<GankIoDataBean.ResultBean> results = data.getResults();
                checkState(results);
                mView.refreshView(results);

            }
        });
    }
}
