package com.example.newsapp.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.newsapp.R;
import com.example.newsapp.models.News;

import java.util.List;

/**
 * an adapter for handling the displaying and the click handling
 * of news items.
 */
public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {

    private List<News> newsList;
    private NewsAdapterListener listener;

    public NewsAdapter(List<News> mNewsList, NewsAdapterListener listener) {
        this.newsList = mNewsList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.new_list_item, parent, false);
        return new NewsViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
        final News news = newsList.get(position);
        holder.newsAuthorTextView.setText(news.getAuthor());
        holder.newsTitleTextView.setText(news.getTitle());
        holder.newsSectionTextView.setText(news.getSection());
        holder.newsDateTextView.setText(news.getDate());
    }

    @Override
    public int getItemCount() {
        return newsList == null ? 0 : newsList.size();
    }

    class NewsViewHolder extends RecyclerView.ViewHolder {

        TextView newsTitleTextView, newsDateTextView, newsAuthorTextView, newsSectionTextView;

        NewsViewHolder(View itemView) {
            super(itemView);
            newsTitleTextView = itemView.findViewById(R.id.news_title_text_view);
            newsDateTextView = itemView.findViewById(R.id.news_date_text_view);
            newsAuthorTextView = itemView.findViewById(R.id.news_author_text_view);
            newsSectionTextView = itemView.findViewById(R.id.news_section_text_view);
            itemView.setOnClickListener(v -> listener.onNewsItemClicked(newsList.get(getAdapterPosition()).getUrl()));
        }
    }
}
