package com.pao11.readerapp.presenter.impl;

import com.pao11.readerapp.bean.douban.HotMovieBean;
import com.pao11.readerapp.http.service.DoubanService;
import com.pao11.readerapp.http.utils.Callback;
import com.pao11.readerapp.presenter.BasePresenter;
import com.pao11.readerapp.presenter.DoubanHotMoviePresenter;

import javax.inject.Inject;

/**
 * Created by pao11 on 2017/3/29.
 */

public class DoubanHotMoviePresenterImpl extends BasePresenter<DoubanHotMoviePresenter.View> implements  DoubanHotMoviePresenter.Presenter {
    private DoubanService mDoubanService;

    @Inject
    public DoubanHotMoviePresenterImpl(DoubanService mDoubanService) {
        this.mDoubanService = mDoubanService;
    }
    @Override
    public void fetchHotMovie() {
        invoke(mDoubanService.fetchHotMovie(),new Callback<HotMovieBean>(){});
    }
}
