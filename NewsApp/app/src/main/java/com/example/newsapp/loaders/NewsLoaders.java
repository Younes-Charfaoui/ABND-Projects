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

    public void setQuery(String query) {
        this.query = query;
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
        try {
            String response = NetworkUtility.makeHttpRequest(url);
            return JsonUtility.parseResult(response);
        } catch (IOException exception) {
            return null;
        }
    }
}
