package com.example.musicalstructure.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.musicalstructure.R;
import com.example.musicalstructure.activities.MusicActivity;
import com.example.musicalstructure.models.Data;

import java.util.List;

/**
 * Data Adapter class for recycler view of generic types, it can handle
 * genre, artist, playlist and album data since we are using inheritance and polymorphism
 * in our class design.
 */
public class DataAdapter extends RecyclerView.Adapter<DataAdapter.DataViewHolder> {

    private List<Data> dataList;
    private int typeData;
    private DataListener listener;

    public DataAdapter(List<Data> dataList, int typeData, DataListener listener) {
        this.dataList = dataList;
        this.typeData = typeData;
        this.listener = listener;
    }

    @NonNull
    @Override
    public DataViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.data_list_item, viewGroup, false);
        return new DataViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DataViewHolder viewHolder, int position) {
        Data data = dataList.get(position);
        if (typeData == MusicActivity.TYPE_ALBUM || typeData == MusicActivity.TYPE_ARTIST) {
            // we want to display image of album or artist.
            viewHolder.dataImage.setVisibility(View.VISIBLE);
            viewHolder.dataImage.setImageResource(data.getImage());
        }
        viewHolder.dataName.setText(data.getName());
    }

    @Override
    public int getItemCount() {
        return dataList != null ? dataList.size() : 0;
    }

    class DataViewHolder extends RecyclerView.ViewHolder {

        private ImageView dataImage;
        private TextView dataName;

        DataViewHolder(@NonNull View itemView) {
            super(itemView);
            dataImage = itemView.findViewById(R.id.data_image);
            dataName = itemView.findViewById(R.id.name_tv);
            itemView.setOnClickListener(view -> listener.onDataClicked(dataList.get(getAdapterPosition())));
        }
    }
}
