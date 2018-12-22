package com.example.newsapp.loaders;

import android.content.AsyncTaskLoader;
import android.content.Context;

import com.example.newsapp.models.News;
import com.example.newsapp.utilis.NetworkUtility;

import java.io.IOException;
import java.net.URL;
import java.util.List;


public class NewsLoaders extends AsyncTaskLoader<List<News>> {


    private String mSource;

    public NewsLoaders(Context context, String source) {
        super(context);

        this.mSource = source;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public List<News> loadInBackground() {

        URL url = NetworkUtility.createUrl(mSource);
        String response = null;
        try {
            response = NetworkUtility.makeHttpRequest(url);
        } catch (IOException ignored) {
        }

        //List<News> news = JsonUtility.getNewsFromJson(response);
        return null;
    }
}
