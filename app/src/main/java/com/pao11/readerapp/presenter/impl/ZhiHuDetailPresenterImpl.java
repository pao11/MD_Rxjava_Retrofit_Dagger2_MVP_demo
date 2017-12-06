package com.pao11.readerapp.presenter.impl;

import com.pao11.readerapp.bean.zhihu.DetailExtraBean;
import com.pao11.readerapp.bean.zhihu.ZhihuDetailBean;
import com.pao11.readerapp.http.service.ZhiHuService;
import com.pao11.readerapp.http.utils.Callback;
import com.pao11.readerapp.presenter.BasePresenter;
import com.pao11.readerapp.presenter.ZhiHuDetailPresenter;

import javax.inject.Inject;

/**
 * Created by pao11 on 2017/3/24.
 */

public class ZhiHuDetailPresenterImpl extends BasePresenter<ZhiHuDetailPresenter.View> implements ZhiHuDetailPresenter.Presenter {
    private ZhiHuService mZhiHuService;

    @Inject
    public ZhiHuDetailPresenterImpl(ZhiHuService mZhiHuService) {
        this.mZhiHuService = mZhiHuService;
    }

    public void fetchDetailInfo(int id){
        invoke(mZhiHuService.fetchDetailInfo(id),new Callback<ZhihuDetailBean>(){
            @Override
            public void onResponse(ZhihuDetailBean data) {
                mView.refreshView(data);
            }
        });
    }

    @Override
    public void fetchDetailExtraInfo(int id) {
        invoke(mZhiHuService.fetchDetailExtraInfo(id),new Callback<DetailExtraBean>(){
            @Override
            public void onResponse(DetailExtraBean data) {
                mView.showExtraInfo(data);
            }
        });
    }

}
