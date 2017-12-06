package com.pao11.readerapp.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.pao11.readerapp.R;
import com.youth.banner.loader.ImageLoader;

/**
 * Created by pao11 on 2017/3/24.
 */

public class GlideImageLoader extends ImageLoader {
    @Override
    public void displayImage(Context context, Object url, ImageView imageView) {
        Glide.with(context).load(url)
                .placeholder(R.mipmap.img_two_bi_one)
                .error(R.mipmap.img_two_bi_one)
                .crossFade(1000)
                .into(imageView);
    }
}
