package com.example.musicalstructure.utils;

import com.example.musicalstructure.R;
import com.example.musicalstructure.activities.MusicActivity;
import com.example.musicalstructure.models.Album;
import com.example.musicalstructure.models.Artist;
import com.example.musicalstructure.models.Data;
import com.example.musicalstructure.models.Song;

import java.util.ArrayList;
import java.util.List;

public class DataProvider {

    private static List<Data> albumList;
    private static List<Data> artistList;
    private static List<Data> genreList;
    private static List<Data> playList;

    static {
        albumList = new ArrayList<>();
        artistList = new ArrayList<>();
        genreList = new ArrayList<>();
        playList = new ArrayList<>();

        List<Song> albumSongsOne = new ArrayList<>();
        List<Song> albumSongsTwo = new ArrayList<>();
        albumSongsOne.add(new Song("Unconditionally", "Katy Pery", "Prism", "3:30", R.drawable.ic_five));
        albumSongsOne.add(new Song("Roar", "Katy Pery", "Prism", "3:54", R.drawable.ic_five));
        albumSongsOne.add(new Song("Dummy Title", "Dummy Artist", "Dummy Album", "3:20", R.drawable.ic_five));

        albumSongsTwo.add(new Song("Gorilla", "Bruno Mars", "Unorthodox Jukebox", "3:30", R.drawable.ic_five));
        albumSongsTwo.add(new Song("When I was Your man", "Bruno Mars", "Unorthodox Jukebox", "4:01", R.drawable.ic_five));
        albumSongsTwo.add(new Song("UP town", "Bruno Mars", "Something", "2:22", R.drawable.ic_five));

        albumList.add(new Album(R.drawable.ic_two, albumSongsOne, "Prism"));
        albumList.add(new Album(R.drawable.ic_two, albumSongsTwo, "Unorthodox Jukebox"));

        artistList.add(new Artist(R.drawable.ic_four, albumSongsOne, "Kety Pery"));
        artistList.add(new Artist(R.drawable.ic_four, albumSongsTwo, "Bruno Mars"));
    }

    public static List<Data> getData(int type) {
        switch (type) {
            case MusicActivity.TYPE_ARTIST:
                return artistList;
            case MusicActivity.TYPE_PLAYLIST:
                return playList;
            case MusicActivity.TYPE_GENRE:
                return genreList;
            case MusicActivity.TYPE_ALBUM:
                return albumList;
            default:
                return albumList;
        }
    }
}
