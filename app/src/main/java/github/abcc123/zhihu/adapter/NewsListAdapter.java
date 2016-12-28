package github.abcc123.zhihu.adapter;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import github.abcc123.zhihu.R;
import github.abcc123.zhihu.bean.News;
import github.abcc123.zhihu.utils.DateUtil;

/**
 * Created by xintong on 2016/12/28.
 */

public class NewsListAdapter extends RecyclerView.Adapter<NewsListAdapter.NewsViewHolder>{
    private Context mContext;
    private List<News.StoriesBean> mNewsList;
    private static final int ITEM_NEWS = 0;
    private static final int ITEM_NEWS_DATE = 1;

    public NewsListAdapter(Context context,List<News.StoriesBean> newsList){
        this.mContext=context;
        this.mNewsList=newsList;

    }
    @Override
    public NewsListAdapter.NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == ITEM_NEWS) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news_list, parent, false);
            return new NewsViewHolder(view);
        } else {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news_list_date, parent, false);
            return new NewsDateViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(NewsListAdapter.NewsViewHolder holder, int position) {
        final News.StoriesBean news = mNewsList.get(position);
        if (news == null) {
            return;
        }
        if (holder instanceof NewsDateViewHolder) {
            NewsDateViewHolder dateHolder = (NewsDateViewHolder) holder;
            String dateFormat = null;
            dateFormat = DateUtil.formatDate(news.getDate());
            dateHolder.mTvNewsDate.setText(dateFormat);
            bindViewHolder(dateHolder, position, news);
        } else {
            bindViewHolder(holder, position, news);
        }
    }
    private void bindViewHolder(final NewsViewHolder holder, int position, final News.StoriesBean news) {
        holder.mTvTitle.setText(news.getTitle());
        List<String> images = news.getImages();
        if (images != null && images.size() > 0) {
            Glide.with(mContext).load(images.get(0)).placeholder(R.mipmap.ic_placeholder).into(holder.mIvNews);
        }

            if (!news.isRead()) {
                holder.mTvTitle.setTextColor(ContextCompat.getColor(mContext, R.color.textColorFirst_Night));
            } else {
                holder.mTvTitle.setTextColor(ContextCompat.getColor(mContext, R.color.textColorThird_Night));

        }
    }
    @Override
    public int getItemCount() {
        return mNewsList == null ? 0 : mNewsList.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return ITEM_NEWS;
        }
        String currentDate = mNewsList.get(position).getDate();
        int preIndex = position - 1;
        boolean isDifferent = !mNewsList.get(preIndex).getDate().equals(currentDate);
        return isDifferent ? ITEM_NEWS_DATE : ITEM_NEWS;
    }

    class NewsViewHolder extends RecyclerView.ViewHolder {

        CardView mCvItem;
        ImageView mIvNews;
        TextView mTvTitle;

        public NewsViewHolder(View itemView) {
            super(itemView);

            mIvNews= (ImageView) itemView.findViewById(R.id.iv_news);
            mTvTitle= (TextView) itemView.findViewById(R.id.tv_title);


        }
    }
    class NewsDateViewHolder extends NewsViewHolder{
        TextView mTvNewsDate;
        public NewsDateViewHolder(View itemview){
            super(itemview);
            mTvNewsDate= (TextView) itemview.findViewById(R.id.tv_news_date);
        }
    }

    public void changeData(List<News.StoriesBean> newsList) {
        mNewsList = newsList;
        notifyDataSetChanged();
    }

    public void addData(List<News.StoriesBean> newsList) {
        if (mNewsList == null) {
            changeData(newsList);
        } else {
            mNewsList.addAll(newsList);
            notifyDataSetChanged();
        }
    }
}
