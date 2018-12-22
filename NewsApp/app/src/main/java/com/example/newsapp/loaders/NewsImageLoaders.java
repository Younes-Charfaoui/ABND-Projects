package com.example.newsapp.loaders;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;


public class NewsImageLoaders extends AsyncTaskLoader<Bitmap> {

    private URL mUrl;

    public NewsImageLoaders(Context context, URL mUrl) {
        super(context);
        this.mUrl = mUrl;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public Bitmap loadInBackground() {
        Bitmap image = null;

        if (mUrl == null)
            return null;

        try {
            InputStream inputStream = mUrl.openStream();
            image = BitmapFactory.decodeStream(inputStream);
        } catch (IOException ignored) {
        }
        return image;
    }
}
