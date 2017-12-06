package com.pao11.readerapp.presenter.impl;

import com.pao11.readerapp.bean.douban.MovieDetailBean;
import com.pao11.readerapp.http.service.DoubanService;
import com.pao11.readerapp.http.utils.Callback;
import com.pao11.readerapp.presenter.BasePresenter;
import com.pao11.readerapp.presenter.DoubanMovieDetailPresenter;

import javax.inject.Inject;

/**
 * Created by pao11 on 2017/3/28.
 */

public class DoubanMovieDetailPresenterImpl extends BasePresenter<DoubanMovieDetailPresenter.View> implements DoubanMovieDetailPresenter.Presenter {
    private DoubanService mDoubanService;

    @Inject
    public DoubanMovieDetailPresenterImpl(DoubanService mDoubanService) {
        this.mDoubanService = mDoubanService;
    }

    @Override
    public void fetchMovieDetail(String id) {
        invoke(mDoubanService.fetchMovieDetail(id),new Callback<MovieDetailBean>(){
        });
    }
}
