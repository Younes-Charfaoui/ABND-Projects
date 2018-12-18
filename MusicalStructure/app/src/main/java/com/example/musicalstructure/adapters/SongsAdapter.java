package com.example.musicalstructure.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.musicalstructure.R;
import com.example.musicalstructure.models.Song;

import java.util.List;

/**
 * This adapter is for Songs for a given album, playlist, genre or artist.
 */
public class SongsAdapter extends RecyclerView.Adapter<SongsAdapter.DataViewHolder> {

    private List<Song> songList;
    private SongListener listener;

    public SongsAdapter(List<Song> songList, SongListener listener) {
        this.songList = songList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public DataViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.song_list_item, viewGroup, false);
        return new DataViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DataViewHolder viewHolder, int position) {
        Song song = songList.get(position);
        viewHolder.songName.setText(song.getName());
        viewHolder.songLength.setText(song.getLength());
        viewHolder.songArtist.setText(song.getArtist());
        viewHolder.songImage.setImageResource(song.getImageResource());
    }

    @Override
    public int getItemCount() {
        return songList != null ? songList.size() : 0;
    }

    class DataViewHolder extends RecyclerView.ViewHolder {

        private ImageView songImage;
        private TextView songName, songLength, songArtist;

        DataViewHolder(@NonNull View itemView) {
            super(itemView);
            songImage = itemView.findViewById(R.id.song_image);
            songName = itemView.findViewById(R.id.song_name_tv);
            songLength = itemView.findViewById(R.id.song_length_tv);
            songArtist = itemView.findViewById(R.id.song_artist_tv);
            itemView.setOnClickListener(view -> listener.onSongClicked(songList.get(getAdapterPosition())));
        }
    }
}
