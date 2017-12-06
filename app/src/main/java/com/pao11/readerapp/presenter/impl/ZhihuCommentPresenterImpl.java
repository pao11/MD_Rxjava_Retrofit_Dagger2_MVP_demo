package com.pao11.readerapp.presenter.impl;

import com.pao11.readerapp.bean.zhihu.CommentBean;
import com.pao11.readerapp.http.service.ZhiHuService;
import com.pao11.readerapp.http.utils.Callback;
import com.pao11.readerapp.presenter.BasePresenter;
import com.pao11.readerapp.presenter.ZhihuCommentPresenter;

import javax.inject.Inject;

/**
 * Created by pao11 on 2017/3/25.
 */

public class ZhihuCommentPresenterImpl extends BasePresenter<ZhihuCommentPresenter.View> implements ZhihuCommentPresenter.Presenter {
    private ZhiHuService mZhiHuService;

    @Inject
    public ZhihuCommentPresenterImpl(ZhiHuService mZhiHuService) {
        this.mZhiHuService = mZhiHuService;
    }


    public void fetchLongCommentInfo(int id){
        invoke(mZhiHuService.fetchLongCommentInfo(id),new Callback<CommentBean>(){
            @Override
            public void onResponse(CommentBean data) {
                checkState(data.getComments());
                mView.refreshView(data.getComments());
            }
        });
    }
    public void fetchShortCommentInfo(int id){
        invoke(mZhiHuService.fetchShortCommentInfo(id),new Callback<CommentBean>(){
            @Override
            public void onResponse(CommentBean data) {
                checkState(data.getComments());
                mView.refreshView(data.getComments());
            }
        });
    }

}
