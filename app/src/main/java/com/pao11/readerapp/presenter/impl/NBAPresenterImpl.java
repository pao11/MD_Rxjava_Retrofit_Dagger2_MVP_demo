package com.pao11.readerapp.presenter.impl;

import com.pao11.readerapp.bean.topnews.NBAListBean;
import com.pao11.readerapp.http.service.TopNewsService;
import com.pao11.readerapp.http.utils.Callback;
import com.pao11.readerapp.presenter.BasePresenter;
import com.pao11.readerapp.presenter.NBAPresenter;

import javax.inject.Inject;

/**
 * Created by pao11 on 2017/4/12.
 */

public class NBAPresenterImpl extends BasePresenter<NBAPresenter.View> implements NBAPresenter.Presenter {
    private TopNewsService mTopNewsService;

    @Inject
    public NBAPresenterImpl(TopNewsService mTopNewsService) {
        this.mTopNewsService = mTopNewsService;
    }

    @Override
    public void fetchNBAList(int id) {
        invoke(mTopNewsService.fetchNBA(id),new Callback<NBAListBean>());
    }
}
