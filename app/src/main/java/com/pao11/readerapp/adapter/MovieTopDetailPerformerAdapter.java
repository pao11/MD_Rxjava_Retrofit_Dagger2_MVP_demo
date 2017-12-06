package com.pao11.readerapp.adapter;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.pao11.readerapp.R;
import com.pao11.readerapp.bean.douban.PersonBean;
import com.pao11.readerapp.utils.GlideUtils;
import com.pao11.readerapp.webview.WebViewActivity;

import java.util.List;

/**
 * Created by pao11 on 2017/3/29.
 */

public class MovieTopDetailPerformerAdapter extends BaseQuickAdapter<PersonBean,BaseViewHolder> {
    public MovieTopDetailPerformerAdapter(List<PersonBean> data) {
        super(R.layout.item_movie_top_detail_performer,data);
    }

    @Override
    protected void convert(BaseViewHolder helper, final PersonBean item) {
        helper.setText(R.id.tv_performer_name,item.getName());
        helper.setText(R.id.tv_performer,item.getType());
        if (item.getAvatars()!=null)
        GlideUtils.loadImage(3,item.getAvatars().getLarge(), (ImageView) helper.getView(R.id.iv_avatar));

        helper.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (item != null && !TextUtils.isEmpty(item.getAlt())) {
                    WebViewActivity.loadUrl(v.getContext(), item.getAlt(), item.getName());
                }
            }
        });
    }
}
