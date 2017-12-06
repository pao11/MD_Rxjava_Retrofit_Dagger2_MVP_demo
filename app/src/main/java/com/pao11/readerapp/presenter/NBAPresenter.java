package com.pao11.readerapp.presenter;

import com.pao11.readerapp.bean.topnews.NBAListBean;

/**
 * Created by pao11 on 2017/4/12.
 */

public interface NBAPresenter {

    interface View extends BaseView<NBAListBean> {
    }

    interface Presenter {
        void fetchNBAList(int id);
    }

}
