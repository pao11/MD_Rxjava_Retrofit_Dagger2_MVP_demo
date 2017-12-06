package com.pao11.readerapp.presenter;

import com.pao11.readerapp.bean.zhihu.SectionChildListBean;
import com.pao11.readerapp.bean.zhihu.ThemeChildListBean;

/**
 * Created by pao11 on 2017/3/27.
 */

public interface ZhihuThemeDetailPresenter {

    interface View extends BaseView<ThemeChildListBean> {
        void refreshSectionData(SectionChildListBean data);
    }

    interface Presenter{
        void fetchThemeChildList(int id);
        void fetchSectionChildList(int id);
    }
}
