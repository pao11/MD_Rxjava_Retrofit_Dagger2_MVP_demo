package com.pao11.readerapp.presenter;

import com.pao11.readerapp.bean.zhihu.DetailExtraBean;
import com.pao11.readerapp.bean.zhihu.ZhihuDetailBean;

/**
 * Created by pao11 on 2017/3/24.
 */

public interface ZhiHuDetailPresenter {

    interface View extends BaseView<ZhihuDetailBean> {
        void showExtraInfo(DetailExtraBean detailExtraBean);
    }

    interface Presenter{
        void fetchDetailInfo(int id);
        void fetchDetailExtraInfo(int id);
    }
}
