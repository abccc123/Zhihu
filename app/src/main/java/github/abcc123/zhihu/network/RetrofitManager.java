package github.abcc123.zhihu.network;

import github.abcc123.zhihu.bean.News;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

/**
 * Created by xintong on 2016/12/28.
 */

public class RetrofitManager {
    public static final String BASE_ZHIHU_URL = "http://news-at.zhihu.com/api/4/";
    private ZhihuService mZhihuService;
    public static RetrofitManager builder(){
        return new RetrofitManager();
    }

    private RetrofitManager() {


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_ZHIHU_URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        mZhihuService = retrofit.create(ZhihuService.class);
    }

    public Observable<News> getLatestNews(){
        return mZhihuService.getLatestNews();
    }

    public Observable<News> getBeforeNews(String date){
        return mZhihuService.getBeforeNews(date);
    }

    public Observable<News> getNewsDetail(int id) {
        return mZhihuService.getNewsDetail(id);
    }
}
