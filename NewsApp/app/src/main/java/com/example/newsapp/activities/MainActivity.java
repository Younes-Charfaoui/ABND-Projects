package com.example.newsapp.activities;

import android.app.LoaderManager;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.Intent;
import android.content.Loader;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.newsapp.R;
import com.example.newsapp.adapters.NewsAdapter;
import com.example.newsapp.adapters.NewsAdapterListener;
import com.example.newsapp.loaders.NewsLoaders;
import com.example.newsapp.models.News;
import com.example.newsapp.utilis.NetworkUtility;

import java.util.List;

public class MainActivity extends AppCompatActivity implements LoaderCallbacks<List<News>>, NewsAdapterListener {

    private static final int NEWS_LOADER_ID = 22;
    private RecyclerView newsRecyclerView;
    private ProgressBar progressBar;
    private LinearLayoutManager linearManager;
    private NewsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        progressBar = findViewById(R.id.news_progress_bar);
        newsRecyclerView = findViewById(R.id.news_recycler_view);

        linearManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        if (NetworkUtility.isConnected(this)) {
            progressBar.setVisibility(View.VISIBLE);
            LoaderManager loaderManager = getLoaderManager();
            loaderManager.initLoader(NEWS_LOADER_ID, null, this);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @NonNull
    @Override
    public Loader<List<News>> onCreateLoader(int i, @Nullable Bundle bundle) {
        return new NewsLoaders(this);
    }

    @Override
    public void onLoadFinished(@NonNull Loader<List<News>> loader, List<News> news) {
        if (news != null) {
            adapter = new NewsAdapter(news, this);
            adapter.notifyDataSetChanged();
            progressBar.setVisibility(View.GONE);
            newsRecyclerView.setVisibility(View.VISIBLE);
            newsRecyclerView.setLayoutManager(linearManager);
            newsRecyclerView.setHasFixedSize(true);
            newsRecyclerView.setAdapter(adapter);
        } else {
            Log.d("loader", "newses is null Genius");
        }
    }

    @Override
    public void onLoaderReset(@NonNull Loader<List<News>> loader) {
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onNewsItemClicked(String url) {
        Intent mWebIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        if (mWebIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(mWebIntent);
        } else {
            Toast.makeText(this, "No app found to display website.", Toast.LENGTH_SHORT).show();
        }
    }
}
