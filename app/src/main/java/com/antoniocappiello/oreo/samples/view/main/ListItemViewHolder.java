package com.antoniocappiello.oreo.samples.view.main;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.antoniocappiello.oreo.samples.R;
import com.antoniocappiello.oreo.samples.model.Sample;
import com.antoniocappiello.oreo.samples.model.SampleType;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by antonio on 30/11/2017.
 */

class ListItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private final InteractionListener listener;

    @BindView(R.id.item_title)
    TextView titleTv;

    @BindView(R.id.item_subtitle)
    TextView subtitleTv;

    private Sample sample;

    public ListItemViewHolder(InteractionListener listener, View view) {
        super(view);
        this.listener = listener;
        ButterKnife.bind(this, view);
        view.setOnClickListener(this);
    }

    public void bindData(Sample sample) {
        this.sample = sample;
        titleTv.setText(sample.getTitle());
        subtitleTv.setText(sample.getSubtitle());
    }

    @Override
    public void onClick(View view) {
        listener.onItemClicked(sample.getType());
    }

    public interface InteractionListener {
        void onItemClicked(SampleType sampleType);
    }
}
