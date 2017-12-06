package com.pao11.readerapp.ui.activity.topnews;

import android.text.TextUtils;

import com.pao11.readerapp.R;
import com.pao11.readerapp.app.AppConstants;
import com.pao11.readerapp.bean.topnews.NewsDetailBean;
import com.pao11.readerapp.bean.topnews.NewsListBean;
import com.pao11.readerapp.injector.component.activity.DaggerTopNewsComponent;
import com.pao11.readerapp.injector.module.http.TopNewsHttpModule;
import com.pao11.readerapp.presenter.TopNewsPresenter;
import com.pao11.readerapp.presenter.impl.TopNewsPresenterImpl;
import com.pao11.readerapp.ui.activity.base.ZhihuDetailBaseActivity;
import com.pao11.readerapp.utils.GlideUtils;

import org.sufficientlysecure.htmltextview.HtmlTextView;

import butterknife.BindView;

/**
 * Created by pao11 on 2017/3/28.
 * 这个页面比较特殊没有用到之前的网络请求
 * 所以大家可以忽略这个页面不看。
 */

public class TopNewsActivity extends ZhihuDetailBaseActivity<TopNewsPresenterImpl> implements TopNewsPresenter.ViewActivity {

    @BindView(R.id.ht_news_content)
    HtmlTextView htNewsContent;
    private String url;

    @Override
    protected void loadData() {
        String id = getIntent().getStringExtra("id");//获取新闻的id
        //获取imgUrl
        url = getIntent().getStringExtra("url");
        mPresenter.getDescrible(id);
    }

    @Override
    public int getContentLayoutId() {
        return R.layout.activity_top_news;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initInject() {
        DaggerTopNewsComponent.builder()
                .topNewsHttpModule(new TopNewsHttpModule())
                .build().injectTopNews(this);
    }


    @Override
    public void refreshView(NewsListBean data) {

    }

    @Override
    public void refreshActivityView(NewsDetailBean newsDetailBean) {
        setState(AppConstants.STATE_SUCCESS);
        if (TextUtils.isEmpty(newsDetailBean.getBody())){
            return;
        }
        htNewsContent.setHtmlFromString(newsDetailBean.getBody(), new HtmlTextView.LocalImageGetter());
        setToolBar(toolbarZhihuDetail, newsDetailBean.getTitle());
        detailBarCopyright.setText(newsDetailBean.getSource());
        GlideUtils.load(this, url, detailBarImage);
    }
}
