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

public class MainActivity extends AppCompatActivity implements LoaderCallbacks<List<News>>, NewsAdapterListener, SearchView.OnQueryTextListener, SwipeRefreshLayout.OnRefreshListener, View.OnClickListener {

    private RecyclerView newsRecyclerView;
    private ProgressBar progressBar;
    private LinearLayoutManager linearManager;
    private NewsAdapter adapter;
    private LinearLayout emptyView;
    private SearchView searchView;
    private SwipeRefreshLayout swipeRefresh;
    private static final int NEWS_LOADER_ID = 22;
    private static final String KEY_QUERY = "keyQuery";
    private static final String KEY_TYPE = "keyType";
    private ImageView emptyImage;
    private TextView emptyText;

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
            case R.id.action_settings:
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @NonNull
    @Override
    public Loader<List<News>> onCreateLoader(int i, @Nullable Bundle bundle) {
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
                progressBar.setVisibility(View.GONE);
                emptyView.setVisibility(View.VISIBLE);
                newsRecyclerView.setVisibility(View.GONE);
                displayEmptyView(R.drawable.no_data, R.string.no_data_text);
            }
        } else {
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
        searchView.setQuery("",false);
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


    private void displayEmptyView(int image, int string) {
        emptyImage.setImageResource(image);
        emptyText.setText(string);
    }

    @Override
    public void onClick(View v) {
        retry();
    }
}
