package com.example.musicalstructure.utils;

import com.example.musicalstructure.R;
import com.example.musicalstructure.activities.MusicActivity;
import com.example.musicalstructure.models.Album;
import com.example.musicalstructure.models.Artist;
import com.example.musicalstructure.models.Data;
import com.example.musicalstructure.models.Genre;
import com.example.musicalstructure.models.Playlist;
import com.example.musicalstructure.models.Song;

import java.util.ArrayList;
import java.util.List;

public class DataProvider {

    // list to hold the data.
    private static List<Data> albumList;
    private static List<Data> artistList;
    private static List<Data> genreList;
    private static List<Data> playList;

    static {
        // List of Data.
        albumList = new ArrayList<>();
        artistList = new ArrayList<>();
        genreList = new ArrayList<>();
        playList = new ArrayList<>();
        //  two list for the albums
        List<Song> albumSongsOne = new ArrayList<>();
        List<Song> albumSongsTwo = new ArrayList<>();
        // populating the first list.
        albumSongsOne.add(new Song("Unconditionally", "Katy Perry", "Prism", "3:30", R.drawable.katy_perry));
        albumSongsOne.add(new Song("Roar", "Katy Perry", "Prism", "3:54", R.drawable.katy_perry));
        albumSongsOne.add(new Song("Teenage Dream", "Katy Perry", "Prism", "3:20", R.drawable.katy_perry));
        // populating the second list.
        albumSongsTwo.add(new Song("Gorilla", "Bruno Mars", "Unorthodox Jukebox", "3:30", R.drawable.bruno_mars));
        albumSongsTwo.add(new Song("When I was Your man", "Bruno Mars", "Unorthodox Jukebox", "4:01", R.drawable.bruno_mars));
        albumSongsTwo.add(new Song("UP town", "Bruno Mars", "Something", "2:22", R.drawable.bruno_mars));
        // populating the album list.
        albumList.add(new Album(R.drawable.katy_perry, albumSongsOne, "Prism"));
        albumList.add(new Album(R.drawable.bruno_mars, albumSongsTwo, "Unorthodox Jukebox"));
        // populating the artist list.
        artistList.add(new Artist(R.drawable.katy_perry, albumSongsOne, "Katy Perry"));
        artistList.add(new Artist(R.drawable.bruno_mars, albumSongsTwo, "Bruno Mars"));
        // making two list for the song of playlist.
        List<Song> playListSongOne = new ArrayList<>();
        List<Song> playListSongTwo = new ArrayList<>();
        // populating the first list.
        playListSongOne.add(albumSongsOne.get(0));
        playListSongOne.add(albumSongsOne.get(1));
        playListSongOne.add(albumSongsTwo.get(1));
        // populating the second list.
        playListSongTwo.add(albumSongsTwo.get(0));
        playListSongTwo.add(albumSongsTwo.get(1));
        playListSongTwo.add(albumSongsOne.get(1));
        // populating the playlist.
        playList.add(new Playlist(playListSongOne, "Favorite"));
        playList.add(new Playlist(playListSongTwo, "Sport"));
        // and finally adding genre.
        genreList.add(new Genre(albumSongsOne, "Pop"));
        genreList.add(new Genre(albumSongsTwo, "Jazz"));
    }

    /**
     * Method that return a specific data list.
     * @param type the type of data we want to return .example : Playlist, Genre
     * @return the list containing the data we want.
     */
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
