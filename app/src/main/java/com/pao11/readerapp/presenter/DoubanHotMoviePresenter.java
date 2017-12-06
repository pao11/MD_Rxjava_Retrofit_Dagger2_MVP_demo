package com.pao11.readerapp.presenter;

import com.pao11.readerapp.bean.douban.HotMovieBean;

/**
 * Created by pao11 on 2017/3/29.
 */

public interface DoubanHotMoviePresenter {
    interface View extends BaseView<HotMovieBean> {
    }

    interface Presenter {
        void fetchHotMovie();
    }
}
