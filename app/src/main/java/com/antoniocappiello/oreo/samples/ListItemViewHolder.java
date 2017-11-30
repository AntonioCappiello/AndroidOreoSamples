package com.antoniocappiello.oreo.samples;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by antonio on 30/11/2017.
 */

class ListItemViewHolder extends RecyclerView.ViewHolder {
    private final InteractionListener listener;

    @BindView(R.id.item_title)
    TextView titleTv;

    @BindView(R.id.item_subtitle)
    TextView subtitleTv;

    public ListItemViewHolder(InteractionListener listener, View view) {
        super(view);
        this.listener = listener;
        ButterKnife.bind(this, view);
    }

    public void bindData(Sample sample) {
        titleTv.setText(sample.getTitle());
        subtitleTv.setText(sample.getSubtitle());
    }

    public interface InteractionListener {
        void onItemClicked();
    }
}
