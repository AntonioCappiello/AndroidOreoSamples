package com.antoniocappiello.oreo.samples.view.main;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.antoniocappiello.oreo.samples.R;
import com.antoniocappiello.oreo.samples.model.Sample;

import java.util.List;

/**
 * Created by antonio on 30/11/2017.
 */

public class SamplesListRecyclerViewAdapter extends RecyclerView.Adapter<ListItemViewHolder> {

    private final ListItemViewHolder.InteractionListener listener;
    private final List<Sample> sampleList;

    public SamplesListRecyclerViewAdapter(ListItemViewHolder.InteractionListener listener, List<Sample> sampleList) {
        this.listener = listener;
        this.sampleList = sampleList;
    }

    @Override
    public ListItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        return new ListItemViewHolder(listener, view);
    }

    @Override
    public void onBindViewHolder(ListItemViewHolder holder, int position) {
        holder.bindData(sampleList.get(position));
    }

    @Override
    public int getItemCount() {
        return sampleList.size();
    }
}
