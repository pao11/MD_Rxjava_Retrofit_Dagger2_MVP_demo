package com.pao11.readerapp.http.service;

import com.pao11.readerapp.bean.topnews.NBADetailBean;
import com.pao11.readerapp.bean.topnews.NBAListBean;
import com.pao11.readerapp.bean.topnews.NewsListBean;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by pao11 on 2017/3/27.
 */

public interface TopNewsService {
    String API_TOPNEWS = "http://c.m.163.com/nc/article/";

    @GET("headline/T1348647909107/{id}-20.html")
    Observable<NewsListBean> fetchNews(@Path("id") int id);

    //   http://c.m.163.com/nc/article/list/T1348649145984/0-20.html
    @GET("list/T1348649145984/{id}-20.html")
    Observable<NBAListBean> fetchNBA(@Path("id") int id);

    //    http://c.m.163.com/nc/article/CHTLBV3C0005877U/full.html
    @GET("{postId}/full.html")
    Observable<NBADetailBean> fetchNewDetail(
            @Path("postId") String postId);

}
