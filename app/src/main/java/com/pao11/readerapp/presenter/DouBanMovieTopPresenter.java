package com.pao11.readerapp.presenter;

import com.pao11.readerapp.bean.douban.HotMovieBean;

/**
 * Created by pao11 on 2017/3/28.
 */

public interface DouBanMovieTopPresenter {
    interface View extends BaseView<HotMovieBean> {
        void showLoadMoreError();
    }

    interface Presenter {
        void fetchMovieTop250(int start,int count);
    }
}
