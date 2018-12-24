package com.example.newsapp.utilis;


import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import static android.content.Context.CONNECTIVITY_SERVICE;

public final class NetworkUtility {

    // some helper constant for the networking activity.
    private static final String BASE_URL = "https://content.guardianapis.com/search";
    private static final String API_KEY = "494a80c1-d254-46fc-90e8-a108e84fde27";
    private static final String KEY_API_KEY = "api-key";
    private static final String KEY_QUERY = "q";
    private static final String KEY_TAGS = "show-tags";
    private static final String KEY_PAGE_SIZE = "page-size";
    private static final String CONTRIBUTOR = "contributor";
    private static final String NUMBER_PAGE_SIZE = "20";

    /**
     * Method that request a remote server from a given  Url.
     * @param url the url we want to request.
     * @return response string.
     * @throws IOException in case of error.
     */
    public static String makeHttpRequest(URL url) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
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

    /**
     * helper method to check if there is connection.
     * @param context context to get system service.
     * @return boolean indicating the state of connection.
     */
    public static boolean isConnected(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.
                getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnected();
    }

    /**
     * method that create a well formed URL given a query search word.
     * @param query the user word.
     * @return well formed URL.
     */
    public static URL createSearchUrl(String query) {
        Uri uri = Uri.parse(BASE_URL).buildUpon().
                appendQueryParameter(KEY_QUERY, query).
                appendQueryParameter(KEY_PAGE_SIZE, NUMBER_PAGE_SIZE).
                appendQueryParameter(KEY_TAGS, CONTRIBUTOR).
                appendQueryParameter(KEY_API_KEY, API_KEY).build();

        URL mUrl = null;
        try {
            mUrl = new URL(uri.toString());
        } catch (MalformedURLException ignored) {
        }
        return mUrl;
    }

    /**
     * method that create a general news well formed URL .
     * @return well formed URL.
     */
    public static URL createNormalUrl() {
        Uri uri = Uri.parse(BASE_URL).buildUpon().
                appendQueryParameter(KEY_PAGE_SIZE, NUMBER_PAGE_SIZE).
                appendQueryParameter(KEY_TAGS, CONTRIBUTOR).
                appendQueryParameter(KEY_API_KEY, API_KEY).build();

        URL mUrl = null;
        try {
            mUrl = new URL(uri.toString());
        } catch (MalformedURLException ignored) {
        }
        return mUrl;
    }
}
