package com.pao11.readerapp.ui.fragment.wechat;


import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.pao11.readerapp.R;
import com.pao11.readerapp.adapter.HomeFragmentPageAdapter;
import com.pao11.readerapp.app.AppConstants;
import com.pao11.readerapp.ui.fragment.BaseFragment;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by pao11 on 2017/3/22.
 */

public class RightFragment extends BaseFragment {

    @BindView(R.id.tab_gank)
    TabLayout tabGank;
    @BindView(R.id.vp_gank)
    ViewPager vpGank;

    private ArrayList<String> mTitleList = new ArrayList<>(3);
    private ArrayList<Fragment> mFragments = new ArrayList<>(3);
    private HomeFragmentPageAdapter myAdapter;

    @Override
    protected void loadData() {
        setState(AppConstants.STATE_SUCCESS);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_gank;
    }

    @Override
    protected void initView() {
        initFragmentList();
        myAdapter = new HomeFragmentPageAdapter(getChildFragmentManager(), mFragments, mTitleList);
        vpGank.setAdapter(myAdapter);
        myAdapter.notifyDataSetChanged();
        tabGank.setTabMode(TabLayout.MODE_FIXED);
        tabGank.setupWithViewPager(vpGank);
    }

    @Override
    protected void initInject() {}


    private void initFragmentList() {
        if (mTitleList.size() != 0) {
            return;
        }
        mTitleList.add("WeChat");
        mTitleList.add("NBA");
        mFragments.add(new WeChatFragment());
        mFragments.add(new NBAFragment());
    }
}
