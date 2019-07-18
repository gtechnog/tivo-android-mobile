package com.gtechnog.sample.tivo.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gtechnog.sample.tivo.R;

public class StripListAdapter extends RecyclerView.Adapter<StripListAdapter.StripViewHolder> {

    StripListAdapter() {
    }

    @NonNull
    @Override
    public StripViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.wtw_strip_view, parent);
        return new StripViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StripViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    static class StripViewHolder extends RecyclerView.ViewHolder {

        public StripViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }


}
