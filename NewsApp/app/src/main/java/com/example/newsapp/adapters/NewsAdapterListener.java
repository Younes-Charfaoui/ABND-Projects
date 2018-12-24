package com.example.newsapp.adapters;

import java.net.URL;

public interface NewsAdapterListener {

    /**
     * The activity that implement this method should handle the case
     * when an item was clicked in a recycler view of news.
     * @param url which lead to the web page that user clicked in
     *            the recycler view.
     */
    void onNewsItemClicked(String url);
}
