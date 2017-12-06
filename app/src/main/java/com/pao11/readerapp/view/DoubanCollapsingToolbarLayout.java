package com.pao11.readerapp.view;

import android.content.Context;
import android.support.design.widget.CollapsingToolbarLayout;
import android.util.AttributeSet;

import com.blankj.utilcode.utils.ConvertUtils;

/**
 * Created by pao11 on 2017/4/17.
 */

public class DoubanCollapsingToolbarLayout extends CollapsingToolbarLayout {
    public DoubanCollapsingToolbarLayout(Context context) {
        this(context,null);
    }

    public DoubanCollapsingToolbarLayout(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public DoubanCollapsingToolbarLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        setMinimumHeight(ConvertUtils.dp2px(55));
        super.onLayout(changed, left, top, right, bottom);

    }
}
