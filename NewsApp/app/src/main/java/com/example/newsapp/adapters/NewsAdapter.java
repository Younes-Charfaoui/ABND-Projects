package com.example.newsapp.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.newsapp.R;
import com.example.newsapp.models.News;

import java.util.List;


public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {

    private List<News> mNewsList;

    public NewsAdapter(List<News> mNewsList) {
        this.mNewsList = mNewsList;
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_main, parent, false);
        return new NewsViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
        final News news = mNewsList.get(position);
    }

    @Override
    public int getItemCount() {
        return mNewsList == null ? 0 : mNewsList.size();
    }

    class NewsViewHolder extends RecyclerView.ViewHolder {

        NewsViewHolder(View itemView) {
            super(itemView);
        }
    }

}
