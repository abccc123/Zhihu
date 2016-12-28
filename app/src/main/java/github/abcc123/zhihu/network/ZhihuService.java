package github.abcc123.zhihu.network;

import github.abcc123.zhihu.bean.News;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by laucherish on 16/3/15.
 */
public interface ZhihuService {


    @GET("stories/latest")
    Observable<News> getLatestNews();


    @GET("stories/before/{date}")
    Observable<News> getBeforeNews(@Path("date") String date);

    @GET("story/{id}")
    Observable<News> getNewsDetail(@Path("id") int id);
}
