package com.example.musicalstructure.adapters;

import com.example.musicalstructure.models.Data;

public interface DataListener {

    /**
     * notify the activity by the listener that elemnt has been clicked at a given position
     * @param data clicked
     */
    void onDataClicked(Data data);
}
