package com.example.newsapp.activities;

import android.app.LoaderManager.LoaderCallbacks;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.content.Loader;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.newsapp.R;
import com.example.newsapp.adapters.NewsAdapter;
import com.example.newsapp.adapters.NewsAdapterListener;
import com.example.newsapp.loaders.NewsLoaders;
import com.example.newsapp.models.News;
import com.example.newsapp.utilis.NetworkUtility;

import java.util.List;

/**
 * The Main activity handle the main app characteristic, it does get the information from the
 * server in separate thread, populate the recycler view, handle cases when there is data or not,
 * and also check if there is internet connection.
 */
public class MainActivity extends AppCompatActivity implements LoaderCallbacks<List<News>>, NewsAdapterListener, SearchView.OnQueryTextListener, SwipeRefreshLayout.OnRefreshListener, View.OnClickListener {

    // some views reference to make some operations.
    private RecyclerView newsRecyclerView;
    private ProgressBar progressBar;
    private LinearLayoutManager linearManager;
    private NewsAdapter adapter;
    private LinearLayout emptyView;
    private SearchView searchView;
    private SwipeRefreshLayout swipeRefresh;
    private ImageView emptyImage;
    private TextView emptyText;
    //some constants
    private static final int NEWS_LOADER_ID = 22;
    private static final String KEY_QUERY = "keyQuery";
    private static final String KEY_TYPE = "keyType";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // initializing the views.
        progressBar = findViewById(R.id.news_progress_bar);
        newsRecyclerView = findViewById(R.id.news_recycler_view);
        emptyView = findViewById(R.id.empty_view);
        emptyImage = emptyView.findViewById(R.id.empty_view_image);
        emptyText = emptyView.findViewById(R.id.empty_view_text_view);
        emptyView.setOnClickListener(this);
        linearManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        swipeRefresh = findViewById(R.id.news_refresh);
        swipeRefresh.setOnRefreshListener(this);
        //checking if there is internet connection.
        if (NetworkUtility.isConnected(this)) {
            getLoaderManager().initLoader(NEWS_LOADER_ID, null, this);
        } else {
            progressBar.setVisibility(View.GONE);
            emptyView.setVisibility(View.VISIBLE);
            displayEmptyView(R.drawable.no_connection, R.string.check_your_internet);
            newsRecyclerView.setVisibility(View.GONE);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        MenuItem item = menu.findItem(R.id.action_search);
        // getting the search manager and search view and assigning the actions.
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        searchView = (SearchView) item.getActionView();
        if (searchManager != null)
            searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setMaxWidth(Integer.MAX_VALUE);
        searchView.setOnQueryTextListener(this);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.action_search:
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @NonNull
    @Override
    public Loader<List<News>> onCreateLoader(int id, @Nullable Bundle bundle) {
        progressBar.setVisibility(View.VISIBLE);
        newsRecyclerView.setVisibility(View.INVISIBLE);
        boolean normal = true;
        if (bundle != null)
            normal = bundle.getBoolean(KEY_TYPE);
        NewsLoaders loader = new NewsLoaders(this, normal);
        if (!normal) loader.setQuery(bundle.getString(KEY_QUERY));
        return loader;
    }

    @Override
    public void onLoadFinished(@NonNull Loader<List<News>> loader, List<News> news) {
        if (news != null) {
            if (news.size() != 0) {
                // in case there is some data to work with.
                adapter = new NewsAdapter(news, this);
                adapter.notifyDataSetChanged();
                progressBar.setVisibility(View.GONE);
                emptyView.setVisibility(View.GONE);
                displayEmptyView(R.drawable.no_connection, R.string.check_your_internet);
                newsRecyclerView.setVisibility(View.VISIBLE);
                newsRecyclerView.setLayoutManager(linearManager);
                newsRecyclerView.setHasFixedSize(true);
                newsRecyclerView.setAdapter(adapter);
                swipeRefresh.setRefreshing(false);
            } else {
                // in case of there is no data.
                progressBar.setVisibility(View.GONE);
                emptyView.setVisibility(View.VISIBLE);
                newsRecyclerView.setVisibility(View.GONE);
                displayEmptyView(R.drawable.no_data, R.string.no_data_text);
            }
        } else {
            // in case of error in the app by json exception or IO exception.
            displayEmptyView(R.drawable.no_data, R.string.no_data_text);
        }
    }

    @Override
    public void onLoaderReset(@NonNull Loader<List<News>> loader) {
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onNewsItemClicked(String url) {
        // launching the Website intent with url.
        Intent mWebIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        if (mWebIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(mWebIntent);
        } else {
            Toast.makeText(this, R.string.no_app_found_website, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        // handling the query from the user.
        progressBar.setVisibility(View.VISIBLE);
        searchView.clearFocus();
        Bundle bundle = new Bundle();
        bundle.putBoolean(KEY_TYPE, false);
        bundle.putString(KEY_QUERY, query.trim());
        searchView.setQuery("", false);
        searchView.setIconified(true);
        getLoaderManager().restartLoader(NEWS_LOADER_ID, bundle, MainActivity.this);
        return true;
    }

    @Override
    public boolean onQueryTextChange(String s) {
        return false;
    }

    @Override
    public void onRefresh() {
        retry();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.empty_view:
                // retry when the empty view clicked.
                retry();
                break;
        }
    }

    /**
     * This method handle the retry process which consist of checking if there is internet,
     * if this is the case it does start a loader, otherwise it does display an empty view.
     */
    private void retry() {
        if (NetworkUtility.isConnected(this)) {
            emptyView.setVisibility(View.GONE);
            getLoaderManager().restartLoader(NEWS_LOADER_ID, null, this);
        } else {
            progressBar.setVisibility(View.GONE);
            emptyView.setVisibility(View.VISIBLE);
            displayEmptyView(R.drawable.no_connection, R.string.check_your_internet);
            newsRecyclerView.setVisibility(View.GONE);
            swipeRefresh.setRefreshing(false);
        }
    }

    /**
     * helper method to display the right empty screen.
     *
     * @param image the image we want  to display in the empty view.
     * @param text  the text we want  to display in the empty view.
     */
    private void displayEmptyView(int image, int text) {
        emptyImage.setImageResource(image);
        emptyText.setText(text);
    }
}
