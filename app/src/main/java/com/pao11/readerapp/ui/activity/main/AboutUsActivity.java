package com.pao11.readerapp.ui.activity.main;

import com.pao11.readerapp.R;
import com.pao11.readerapp.ui.activity.base.ToolbarBaseActivity;
import com.pao11.readerapp.webview.WebViewActivity;

import butterknife.OnClick;

/**
 * Created by pao11 on 2017/4/1.
 */

public class AboutUsActivity extends ToolbarBaseActivity {

    @OnClick(R.id.cv_github)
    public void cvGithub() {
        WebViewActivity.loadUrl(this, "https://github.com/pao11/MD_Rxjava_Retrofit_Dagger2_MVP_demo", "加载中。。。");
    }

    @Override
    protected void initUI() {
        tvToolbarTitle.setText("关于我们");
    }

    @Override
    public int getContentLayoutId() {
        return R.layout.activity_about_us;
    }


}
