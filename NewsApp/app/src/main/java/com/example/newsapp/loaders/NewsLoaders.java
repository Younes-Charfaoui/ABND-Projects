package com.example.newsapp.loaders;

import android.content.AsyncTaskLoader;
import android.content.Context;

import com.example.newsapp.models.News;
import com.example.newsapp.utilis.NetworkUtility;

import java.io.IOException;
import java.net.URL;
import java.util.List;


public class NewsLoaders extends AsyncTaskLoader<List<News>> {

    public NewsLoaders(Context context) {
        super(context);
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public List<News> loadInBackground() {

        URL url = NetworkUtility.createUrl("");
        String response = null;
        try {
            response = NetworkUtility.makeHttpRequest(url);
            //List<News> news = JsonUtility.getNewsFromJson(response);
        } catch (IOException ignored) {
            response = null;
        }


        return null;
    }
}
