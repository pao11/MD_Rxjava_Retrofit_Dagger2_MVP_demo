# 简介
模仿网易云音乐UI，用知乎和gankio 网易新闻 豆瓣电影的API来完成一个基于Material Design +Rxjava + Retrofit + dagger2 + MVP构架的项目<br>

<br>[github中APP下载地址](https://github.com/pao11/MD_Rxjava_Retrofit_Dagger2_MVP_demo/blob/master/app-debug.apk)支持5.0以上，本项目可以支持4.0以上不过部分动画会失效，如果要用4.0-5.0的自己去gradle里面修改。

## app截图
![](https://github.com/pao11/MD_Rxjava_Retrofit_Dagger2_MVP_demo/blob/master/imagefile/home.png)
![](https://github.com/pao11/MD_Rxjava_Retrofit_Dagger2_MVP_demo/blob/master/imagefile/zhihudetail.png)
![](https://github.com/pao11/MD_Rxjava_Retrofit_Dagger2_MVP_demo/blob/master/imagefile/movietop.png)
![](https://github.com/pao11/MD_Rxjava_Retrofit_Dagger2_MVP_demo/blob/master/imagefile/movielatest.png)
![](https://github.com/pao11/MD_Rxjava_Retrofit_Dagger2_MVP_demo/blob/master/imagefile/moviedetail.png)<br>


## 特性
* 遵循Material Design设计风格。
* Rxjava+Retrofit2网络请求。
* Dagger2将M层注入P层，将P层注入V层，无需new，直接调用对象。
* BaseRecyclerViewAdapterHelper+RecyclerView完成下拉刷新，上拉加载更多。
* Glide做图片的处理和加载
* 使用CoordinatorLayout + AppBarLayout + CollapsingToolbarLayout。



