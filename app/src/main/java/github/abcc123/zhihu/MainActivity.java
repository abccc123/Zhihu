package github.abcc123.zhihu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import github.abcc123.zhihu.adapter.NewsListAdapter;
import github.abcc123.zhihu.bean.News;
import github.abcc123.zhihu.db.dao.NewDao;
import github.abcc123.zhihu.network.RetrofitManager;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private String curDate;
    private List<News.StoriesBean> stories=new ArrayList<>();
    private NewsListAdapter newsListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadLatestNews();
        initview();
    }
    private void initview(){
        recyclerView= (RecyclerView) findViewById(R.id.rcv_news_list);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        newsListAdapter=new NewsListAdapter(getApplicationContext(),stories);
        recyclerView.setAdapter(newsListAdapter);
    }
    private void loadLatestNews(){
        RetrofitManager.builder().getLatestNews()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(new Action0() {
                    @Override
                    public void call() {

                    }
                })
                .map(new Func1<News, News>() {
                    @Override
                    public News call(News news) {
                        cacheAllDetail(news.getStories());
                        return changeReadState(news);
                    }
                })
                .subscribe(new Action1<News>(){
                    @Override
                    public void call(News news) {
                        if (news.getStories()==null){

                        }else {
                            newsListAdapter.changeData(news.getStories());
                            curDate = news.getDate();
                            Log.e("curDate",curDate);
                        }
                    }
                },new Action1<Throwable>(){
                    @Override
                    public void call(Throwable throwable) {

                    }
                });
    }
    private void cacheAllDetail(List<News.StoriesBean> newsList) {
//        if (NetUtil.isWifiConnected()) {
            for (News.StoriesBean news : newsList) {
                Log.d("Cache news",": " + news.getId() + news.getTitle());
                //cacheNewsDetail(news.getId());
            }
//        }
    }

    public News changeReadState(News newsList) {
        List<String> allReadId = new NewDao(getApplicationContext()).getAllReadNew();
        for (News.StoriesBean news : newsList.getStories()) {
            Log.e("curDate",newsList.getDate());
            news.setDate(newsList.getDate());
            for (String readId : allReadId) {
                if (readId.equals(news.getId() + "")) {
                    news.setRead(true);
                }
            }
        }
        return newsList;
    }
//    private void cacheNewsDetail(int newsId) {
//        RetrofitManager.builder().getNewsDetail(newsId)
//                .subscribeOn(Schedulers.io())
//                .observeOn(Schedulers.io())
//                .subscribe(new Action1<NewsDetail>() {
//                    @Override
//                    public void call(NewsDetail newsDetail) {
////                        ArrayList<String> imgList = getImgs(newsDetail.getBody());
////                        for (String img : imgList) {
////                            L.d("Cache img: " + img);
////                        }
//                    }
//                });
//    }
}
