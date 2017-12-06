package com.pao11.readerapp.presenter.impl;

import com.pao11.readerapp.bean.zhihu.SectionChildListBean;
import com.pao11.readerapp.bean.zhihu.ThemeChildListBean;
import com.pao11.readerapp.http.service.ZhiHuService;
import com.pao11.readerapp.http.utils.Callback;
import com.pao11.readerapp.presenter.BasePresenter;
import com.pao11.readerapp.presenter.ZhihuThemeDetailPresenter;

import javax.inject.Inject;

/**
 * Created by pao11 on 2017/3/27.
 */

public class ZhihuThemeDetailPresenterImpl extends BasePresenter<ZhihuThemeDetailPresenter.View> implements ZhihuThemeDetailPresenter.Presenter {
    private ZhiHuService mZhiHuService;


    @Inject
    public ZhihuThemeDetailPresenterImpl(ZhiHuService mZhiHuService) {
        this.mZhiHuService = mZhiHuService;
    }

    @Override
    public void fetchThemeChildList(int id) {
        invoke(mZhiHuService.fetchThemeChildList(id), new Callback<ThemeChildListBean>() {
            @Override
            public void onResponse(ThemeChildListBean data) {
                mView.refreshView(data);
            }
        });
    }

    @Override
    public void fetchSectionChildList(int id) {
        invoke(mZhiHuService.fetchSectionChildList(id), new Callback<SectionChildListBean>() {
            @Override
            public void onResponse(SectionChildListBean data) {
                mView.refreshSectionData(data);
            }
        });
    }


}
