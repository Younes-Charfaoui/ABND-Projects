package com.example.musicalstructure.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.musicalstructure.R;

public class MusicActivity extends AppCompatActivity {

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
        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
