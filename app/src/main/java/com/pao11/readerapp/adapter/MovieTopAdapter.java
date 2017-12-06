package com.pao11.readerapp.adapter;

import android.view.View;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.pao11.readerapp.R;
import com.pao11.readerapp.bean.douban.HotMovieBean;
import com.pao11.readerapp.utils.DensityUtil;
import com.pao11.readerapp.utils.GlideUtils;

import java.util.List;

/**
 * Created by pao11 on 2017/3/27.
 */

public class MovieTopAdapter extends BaseQuickAdapter<HotMovieBean.SubjectsBean,BaseViewHolder> {
    public MovieTopAdapter(List<HotMovieBean.SubjectsBean> data) {
        super(R.layout.item_movie_top,data);
    }

    @Override
    protected void convert(final BaseViewHolder helper, final HotMovieBean.SubjectsBean item) {
        if (helper.getAdapterPosition() % 3 == 0) {
            DensityUtil.setViewMargin(helper.itemView, false, 0, 5, 0, 40);
        } else if(helper.getAdapterPosition() % 3 == 1){
            DensityUtil.setViewMargin(helper.itemView, false, 0, 5, 0, 40);
        }else if(helper.getAdapterPosition() % 3 == 2){
            DensityUtil.setViewMargin(helper.itemView, false, 0, 0, 0, 40);
        }
        helper.setText(R.id.tv_item_movie_top_name,item.getTitle());
        helper.setText(R.id.tv_item_movie_top_rating,"评分："+String.valueOf(item.getRating().getAverage()));
        GlideUtils.loadImage(3,item.getImages().getLarge(), (ImageView) helper.getView(R.id.iv_item_movie_top));
        helper.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.onItemClickListener(item, helper.getView(R.id.iv_item_movie_top));
            }
        });

    }
    OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void onItemClickListener(HotMovieBean.SubjectsBean positionData, View view);}

}
