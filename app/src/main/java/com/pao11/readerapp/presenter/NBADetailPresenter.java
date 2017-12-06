package com.pao11.readerapp.presenter;

import com.pao11.readerapp.bean.topnews.NewsDetailBean;

/**
 * Created by pao11 on 2017/4/13.
 */

public interface NBADetailPresenter {
    interface View extends BaseView<NewsDetailBean> {
    }

    interface Presenter{
        void fetchNBADetail(String  id);
    }
}
