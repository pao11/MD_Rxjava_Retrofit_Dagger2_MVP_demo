package com.pao11.readerapp.presenter;

import com.pao11.readerapp.bean.zhihu.CommentBean;

import java.util.List;

/**
 * Created by pao11 on 2017/3/25.
 */

public interface ZhihuCommentPresenter {

    interface View extends BaseView<List<CommentBean.CommentsBean>> {
    }

    interface Presenter{
        void fetchLongCommentInfo(int id);
        void fetchShortCommentInfo(int id);
    }
}
