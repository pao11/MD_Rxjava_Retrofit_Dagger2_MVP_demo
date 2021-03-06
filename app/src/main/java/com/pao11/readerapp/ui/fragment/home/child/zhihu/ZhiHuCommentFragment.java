package com.pao11.readerapp.ui.fragment.home.child.zhihu;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.pao11.readerapp.R;
import com.pao11.readerapp.bean.zhihu.CommentBean;
import com.pao11.readerapp.injector.component.fragment.DaggerZhihuCommentComponent;
import com.pao11.readerapp.injector.module.fragment.ZhihuCommentModule;
import com.pao11.readerapp.injector.module.http.ZhihuHttpModule;
import com.pao11.readerapp.presenter.ZhihuCommentPresenter;
import com.pao11.readerapp.presenter.impl.ZhihuCommentPresenterImpl;
import com.pao11.readerapp.ui.activity.zhihu.ZhiHuCommentActivity;
import com.pao11.readerapp.ui.fragment.BaseFragment;

import java.util.List;

import butterknife.BindView;

/**
 * Created by pao11 on 2017/3/25.
 */

public class ZhiHuCommentFragment extends BaseFragment<ZhihuCommentPresenterImpl> implements ZhihuCommentPresenter.View {

    @BindView(R.id.rv_zhihu_comment)
    RecyclerView rvZhihuComment;

    private boolean isShort;

    public static ZhiHuCommentFragment getInstance(boolean isShort) {
        ZhiHuCommentFragment instance = new ZhiHuCommentFragment();
        instance.isShort = isShort;
        return instance;
    }

    @Override
    protected void initView() {
        rvZhihuComment.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    @Override
    protected void loadData() {
        ZhiHuCommentActivity mZhiHuCommentActivity = (ZhiHuCommentActivity) getActivity();
        int id = mZhiHuCommentActivity.getId();
        if (isShort) {//懒加载在可见的时候加载，会让非静态变量最终都是同一个值所以只能用静态变量。
            mPresenter.fetchShortCommentInfo(id);
        } else {
            mPresenter.fetchLongCommentInfo(id);
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_zhihu_comment;
    }

    @Override
    protected void initInject() {
        DaggerZhihuCommentComponent.builder()
                .zhihuHttpModule(new ZhihuHttpModule())
                .zhihuCommentModule(new ZhihuCommentModule())
                .build().injectZhihuComment(this);
    }



    @Override
    public void refreshView(List<CommentBean.CommentsBean> list) {
        mAdapter.setNewData(list);
        rvZhihuComment.setAdapter(mAdapter);
    }
}
