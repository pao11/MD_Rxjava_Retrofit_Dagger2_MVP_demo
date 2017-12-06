package com.pao11.readerapp.ui.activity.zhihu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.NestedScrollView;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.pao11.readerapp.R;
import com.pao11.readerapp.bean.zhihu.DetailExtraBean;
import com.pao11.readerapp.bean.zhihu.ZhihuDetailBean;
import com.pao11.readerapp.injector.component.activity.DaggerZhihuDetailComponent;
import com.pao11.readerapp.injector.module.http.ZhihuHttpModule;
import com.pao11.readerapp.presenter.ZhiHuDetailPresenter;
import com.pao11.readerapp.presenter.impl.ZhiHuDetailPresenterImpl;
import com.pao11.readerapp.ui.activity.base.ZhihuDetailBaseActivity;
import com.pao11.readerapp.utils.GlideUtils;
import com.pao11.readerapp.utils.HtmlUtil;
import com.pao11.readerapp.utils.ShareUtils;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by pao11 on 2017/3/24.
 */

public class ZhiHuDetailActivity extends ZhihuDetailBaseActivity<ZhiHuDetailPresenterImpl> implements ZhiHuDetailPresenter.View {

    @BindView(R.id.tv_detail_bottom_like)
    TextView tvDetailBottomLike;
    @BindView(R.id.tv_detail_bottom_comment)
    TextView tvDetailBottomComment;
    @BindView(R.id.fl_detail_bottom)
    FrameLayout flDetailBottom;
    @BindView(R.id.nsv_zhihu_detail)
    NestedScrollView nsvZhihuDetail;
    @BindView(R.id.wv_detail_content)
    WebView wvDetailContent;
    int allNum = 0;
    int shortNum = 0;
    int longNum = 0;
    String shareUrl;
    boolean isBottomShow = true;
    boolean isImageShow = false;
    boolean isTransitionEnd = false;
    String imgUrl;
    boolean isNotTransition = false;
    private int id;

    @Override
    protected void initInject() {
        DaggerZhihuDetailComponent.builder()
                .zhihuHttpModule(new ZhihuHttpModule())
                .build().injectZhiHuDetail(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void initView() {
        //不知道为什么如果webview用addview进FrameLyout会导致真机内存泄露，模拟器不管什么方式都内存泄露，不过真机不用addview就不会。
        WebSettings settings = wvDetailContent.getSettings();
        settings.setAppCacheEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setDatabaseEnabled(true);
        settings.setCacheMode(WebSettings.LOAD_DEFAULT);
        settings.setJavaScriptEnabled(true);
        settings.setLoadWithOverviewMode(true);
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        settings.setSupportZoom(true);
        wvDetailContent.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        nsvZhihuDetail.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            @Override
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                if (scrollY - oldScrollY > 0 && isBottomShow) {  //下移隐藏
                    isBottomShow = false;
                    flDetailBottom.animate().translationY(flDetailBottom.getHeight());
                } else if (scrollY - oldScrollY < 0 && !isBottomShow) {    //上移出现
                    isBottomShow = true;
                    flDetailBottom.animate().translationY(0);
                }
            }
        });
    }

    @Override
    public void loadData() {
        id = getIntent().getIntExtra("id", 0);
        isNotTransition = getIntent().getBooleanExtra("isNotTransition", false);
        mPresenter.fetchDetailInfo(id);
        mPresenter.fetchDetailExtraInfo(id);
    }

    @Override
    public int getContentLayoutId() {
        return R.layout.activity_zhihu_detail;
    }

    @Override
    public void showExtraInfo(DetailExtraBean detailExtraBean) {
        tvDetailBottomLike.setText(String.format("%d个赞", detailExtraBean.getPopularity()));
        tvDetailBottomComment.setText(String.format("%d条评论", detailExtraBean.getComments()));
        allNum = detailExtraBean.getComments();
        shortNum = detailExtraBean.getShort_comments();
        longNum = detailExtraBean.getLong_comments();
    }

    @Override
    public void refreshView(ZhihuDetailBean zhihuDetailBean) {
        imgUrl = zhihuDetailBean.getImage();
        shareUrl = zhihuDetailBean.getShare_url();
        if (isNotTransition) {
            GlideUtils.loadDetailImg(this, zhihuDetailBean.getImage(), detailBarImage);
        } else {
            if (!isImageShow && isTransitionEnd) {
                GlideUtils.loadDetailImg(this, zhihuDetailBean.getImage(), detailBarImage);
            }
        }
        toolbarZhihuDetail.setTitle(zhihuDetailBean.getTitle());
        detailBarCopyright.setText(zhihuDetailBean.getImage_source());
        String htmlData = HtmlUtil.createHtmlData(zhihuDetailBean.getBody(), zhihuDetailBean.getCss(), zhihuDetailBean.getJs());
        wvDetailContent.loadData(htmlData, HtmlUtil.MIME_TYPE, HtmlUtil.ENCODING);
    }

    @OnClick(R.id.tv_detail_bottom_share)
    void shareUrl() {
        ShareUtils.shareText(this, shareUrl, "分享一篇文章");
    }

    @OnClick(R.id.tv_detail_bottom_comment)
    void gotoComment() {
        Intent intent = new Intent();
        intent.setClass(this, ZhiHuCommentActivity.class);
        intent.putExtra("id", id);
        intent.putExtra("allNum", allNum);
        intent.putExtra("shortNum", shortNum);
        intent.putExtra("longNum", longNum);
        startActivity(intent);
    }

}
