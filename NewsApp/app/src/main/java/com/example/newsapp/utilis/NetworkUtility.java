package com.example.newsapp.utilis;


import android.net.Uri;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public final class NetworkUtility {

    private static final String BASE_URL = "https://content.guardianapis.com/search";
    private static final String API_KEY = "494a80c1-d254-46fc-90e8-a108e84fde27";
    private static final String KEY_API_KEY = "api-key";
    private static final String KEY_QUERY = "q";


    public static String makeHttpRequest(URL mUrl) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) mUrl.openConnection();
        try {
            InputStream inputStream = connection.getInputStream();

            Scanner scanner = new Scanner(inputStream);
            scanner.useDelimiter("\\A");

            boolean hasInput = scanner.hasNext();

            if (hasInput) {
                return scanner.next();
            } else {
                return null;
            }
        } finally {
            connection.disconnect();
        }

    }

    public static URL createUrl(String query) {
        Uri uri = Uri.parse(BASE_URL).buildUpon().
                appendQueryParameter(KEY_QUERY, query).
                appendQueryParameter(KEY_API_KEY, API_KEY).build();

        URL mUrl = null;
        try {
            mUrl = new URL(uri.toString());
        } catch (MalformedURLException ignored) {
        }
        return mUrl;
    }

}
