package com.example.newsapp.utilis;


import com.example.newsapp.models.News;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public final class JsonUtility {

    // some constant to help deserialize the json .
    private static final String STATUS_OK = "ok";
    private static final String KEY_SECTION = "sectionName";
    private static final String KEY_PUBLICATION_DATE = "webPublicationDate";
    private static final String KEY_TITLE = "webTitle";
    private static final String KEY_WEB_URL = "webUrl";
    private static final String KEY_TAGS = "tags";
    private static final String KEY_RESULT = "results";
    private static final String KEY_RESPONSE = "response";
    private static final String KEY_STATUS = "status";

    /**
     * This method takes care of deserialize a json string into list of news.
     * @param result the response string from the server.
     * @return news object in a list.
     */
    public static List<News> parseResult(String result) {
        List<News> newsList = new ArrayList<>();
        try {
            JSONObject jsonObject = new JSONObject(result);
            JSONObject response = jsonObject.getJSONObject(KEY_RESPONSE);
            String status = response.getString(KEY_STATUS);
            if (!status.equals(STATUS_OK)) {
                return null;
            } else {
                JSONArray results = response.getJSONArray(KEY_RESULT);
                for (int i = 0; i < results.length(); i++) {
                    JSONObject data = results.getJSONObject(i);
                    String section = data.getString(KEY_SECTION);
                    String title = data.getString(KEY_TITLE);
                    String webUrl = data.getString(KEY_WEB_URL);
                    String date = data.getString(KEY_PUBLICATION_DATE).substring(0, 10);
                    String author = "Unknown";
                    if (data.has(KEY_TAGS)) {
                        JSONArray tags = data.getJSONArray(KEY_TAGS);
                        if (tags.length() != 0) {
                            JSONObject firstTag = tags.getJSONObject(0);
                            author = firstTag.getString(KEY_TITLE);
                        }
                    }
                    newsList.add(new News(title, author, webUrl, date, section));
                }
            }
            return newsList;
        } catch (JSONException e) {
            return null;
        }
    }
}
