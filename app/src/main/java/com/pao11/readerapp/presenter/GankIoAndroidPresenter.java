package com.pao11.readerapp.presenter;

import com.pao11.readerapp.bean.gankio.GankIoDataBean;

import java.util.List;

/**
 * Created by pao11 on 2017/3/30.
 */

public interface GankIoAndroidPresenter {

    interface View extends BaseView<List<GankIoDataBean.ResultBean>> {
    }

    interface Presenter{
        void fetchGankIoData(int page, int pre_page);
    }
}
