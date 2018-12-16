package com.example.musicalstructure.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.example.musicalstructure.models.Data;

import java.util.List;

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
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull DataViewHolder viewHolder, int position) {

    }

    @Override
    public int getItemCount() {
        return dataList != null ? dataList.size() : 0;
    }

    class DataViewHolder extends RecyclerView.ViewHolder {

        public DataViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
