package com.example.newsapp.loaders;

import android.content.AsyncTaskLoader;
import android.content.Context;

import com.example.newsapp.models.News;
import com.example.newsapp.utilis.JsonUtility;
import com.example.newsapp.utilis.NetworkUtility;

import java.io.IOException;
import java.net.URL;
import java.util.List;


/**
 * News Loader class which is the responsible for calling the remote
 * server in a background Thread and retransmit it to the foreground thread
 * throughout its callbacks
 */
public class NewsLoaders extends AsyncTaskLoader<List<News>> {

    // case of general or query based call for server.
    private boolean isNormal;
    // the query word from the user.
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
