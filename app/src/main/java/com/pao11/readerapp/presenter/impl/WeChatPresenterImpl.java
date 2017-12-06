package com.pao11.readerapp.presenter.impl;

import com.pao11.readerapp.app.AppConstants;
import com.pao11.readerapp.bean.wechat.WXHttpResponse;
import com.pao11.readerapp.bean.wechat.WXItemBean;
import com.pao11.readerapp.http.service.WeChatService;
import com.pao11.readerapp.http.utils.Callback;
import com.pao11.readerapp.presenter.BasePresenter;
import com.pao11.readerapp.presenter.WeChatPresenter;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by pao11 on 2017/3/30.
 */

public class WeChatPresenterImpl extends BasePresenter<WeChatPresenter.View> implements WeChatPresenter.Presenter {
    private WeChatService mWeChatService;

    @Inject
    public WeChatPresenterImpl(WeChatService mWeChatService) {
        this.mWeChatService = mWeChatService;
    }

    @Override
    public void fetchWeChatHot(int num, int page) {
        invoke(mWeChatService.fetchWXHot(AppConstants.KEY_API,num, page), new Callback<WXHttpResponse<List<WXItemBean>>>() {
            @Override
            public void onResponse(WXHttpResponse<List<WXItemBean>> data) {
                List<WXItemBean> newslist = data.getNewslist();
                checkState(newslist);
                mView.refreshView(newslist);
            }
        });
    }

    @Override
    public void fetchWXHotSearch(int num, int page, String word) {
        invoke(mWeChatService.fetchWXHotSearch(AppConstants.KEY_API,num, page, word), new Callback<WXHttpResponse<List<WXItemBean>>>() {
            @Override
            public void onResponse(WXHttpResponse<List<WXItemBean>> data) {
                List<WXItemBean> newslist = data.getNewslist();
                checkState(newslist);
                mView.refreshView(newslist);
            }
        });
    }



}
