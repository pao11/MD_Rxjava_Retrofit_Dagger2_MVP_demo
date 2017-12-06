package com.pao11.readerapp.presenter;

import com.pao11.readerapp.bean.topnews.NewsDetailBean;
import com.pao11.readerapp.bean.topnews.NewsListBean;

/**
 * Created by pao11 on 2017/3/27.
 */

public interface TopNewsPresenter {

    interface View extends BaseView<NewsListBean>{
    }

    interface Presenter{
        void fetchTopNewsList(int id);
    }
    interface ViewActivity extends View {
        void refreshActivityView(NewsDetailBean newsDetailBean);
    }

}
