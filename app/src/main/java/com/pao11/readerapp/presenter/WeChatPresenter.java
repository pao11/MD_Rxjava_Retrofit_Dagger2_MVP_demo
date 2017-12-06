package com.pao11.readerapp.presenter;

import com.pao11.readerapp.bean.wechat.WXItemBean;

import java.util.List;

/**
 * Created by pao11 on 2017/3/28.
 */

public interface WeChatPresenter {
    interface View extends BaseView<List<WXItemBean>> {
    }

    interface Presenter {
        void fetchWeChatHot(int num, int page);
        void fetchWXHotSearch(int num, int page, String word);
    }
}
