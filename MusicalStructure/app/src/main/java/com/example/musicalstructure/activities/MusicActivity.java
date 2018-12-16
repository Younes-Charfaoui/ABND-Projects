package com.example.musicalstructure.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.example.musicalstructure.R;
import com.example.musicalstructure.adapters.DataAdapter;
import com.example.musicalstructure.adapters.DataListener;
import com.example.musicalstructure.models.Data;
import com.example.musicalstructure.utils.DataProvider;

public class MusicActivity extends AppCompatActivity implements DataListener {

    public static final String KEY_TYPE = "keyType";
    public static final int TYPE_ARTIST = 101;
    public static final int TYPE_PLAYLIST = 102;
    public static final int TYPE_ALBUM = 103;
    public static final int TYPE_GENRE = 104;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        int type = getIntent().getIntExtra(KEY_TYPE, 100);
        setActivityName(type);

        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        RecyclerView dataRecyclerView = findViewById(R.id.data_recycler_view);
        DataAdapter adapter = new DataAdapter(DataProvider.getData(type), type, this);
        LinearLayoutManager manager = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false);
        dataRecyclerView.setAdapter(adapter);
        dataRecyclerView.setLayoutManager(manager);
    }

    private void setActivityName(int type) {
        switch (type) {
            case TYPE_ARTIST:
                setTitle("Artists");
                break;
            case TYPE_PLAYLIST:
                setTitle("Playlist");
                break;
            case TYPE_GENRE:
                setTitle("Genres");
                break;
            case TYPE_ALBUM:
                setTitle("Albums");
                break;
            default:
                setTitle("Songs");
        }
    }

    @Override
    public void onDataClicked(Data data) {

    }
}
