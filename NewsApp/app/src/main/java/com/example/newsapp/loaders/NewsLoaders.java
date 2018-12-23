package com.example.newsapp.loaders;

import android.content.AsyncTaskLoader;
import android.content.Context;

import com.example.newsapp.models.News;
import com.example.newsapp.utilis.JsonUtility;
import com.example.newsapp.utilis.NetworkUtility;

import java.io.IOException;
import java.net.URL;
import java.util.List;


public class NewsLoaders extends AsyncTaskLoader<List<News>> {

    private boolean isNormal;
    private String query;

    public NewsLoaders(Context context, boolean normal) {
        super(context);
        this.isNormal = normal;
    }


    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public List<News> loadInBackground() {
        URL url;
        if (isNormal) {
            url = NetworkUtility.createNormalUrl();
        } else {
            url = NetworkUtility.createSearchUrl(query);
        }
        String response = null;
        try {
            response = NetworkUtility.makeHttpRequest(url);
            List<News> news = JsonUtility.parseResult(response);
        } catch (IOException ignored) {
        }

        return null;
    }

    public void setQuery(String query) {
        this.query = query;
    }
}
