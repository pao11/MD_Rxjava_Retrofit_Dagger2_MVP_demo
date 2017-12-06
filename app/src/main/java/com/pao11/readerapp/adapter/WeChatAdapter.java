package com.pao11.readerapp.adapter;

import android.view.View;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.pao11.readerapp.R;
import com.pao11.readerapp.bean.wechat.WXItemBean;
import com.pao11.readerapp.utils.GlideUtils;
import com.pao11.readerapp.webview.WebViewActivity;

import java.util.List;

/**
 * Created by pao11 on 2017/3/30.
 */

public class WeChatAdapter extends BaseQuickAdapter<WXItemBean, BaseViewHolder> {
    public WeChatAdapter(List<WXItemBean> data) {
        super(R.layout.item_wechat, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, final WXItemBean item) {
        GlideUtils.loadMovieTopImg((ImageView) helper.getView(R.id.iv_android_pic),item.getPicUrl());
        helper.setText(R.id.tv_android_des,item.getTitle());
        helper.setText(R.id.tv_android_who,item.getDescription());
        helper.setText(R.id.tv_android_time,item.getCtime());
        helper.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WebViewActivity.loadUrl(mContext,item.getUrl(),item.getTitle());
            }
        });
    }
}
