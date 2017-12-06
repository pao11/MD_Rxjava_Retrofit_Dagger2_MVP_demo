package com.pao11.readerapp.presenter;

import com.pao11.readerapp.bean.douban.MovieDetailBean;

/**
 * Created by pao11 on 2017/3/28.
 */

public interface DoubanMovieDetailPresenter {
    interface View extends BaseView<MovieDetailBean> {
    }

    interface Presenter {
        void fetchMovieDetail(String id);
    }
}
