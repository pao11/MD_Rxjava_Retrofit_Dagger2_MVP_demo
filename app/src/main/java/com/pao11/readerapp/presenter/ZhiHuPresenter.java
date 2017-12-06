package com.pao11.readerapp.presenter;

import com.pao11.readerapp.bean.zhihu.HomeListBean;

import java.util.List;

/**
 * Created by pao11 on 2017/3/23.
 * 某个页面的Presenter都按以下的来写，类名XXXPresenter，除了方法名字不一样别的都一样
 */

public interface ZhiHuPresenter {

    interface View extends BaseView<List<HomeListBean>>{
    }

    interface Presenter{
        void fetchDailyData();
        void fetchThemeList();
        void fetchSectionList();
        void fetchHotList();
    }
}
