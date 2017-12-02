package com.antoniocappiello.oreo.samples.view.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.antoniocappiello.oreo.samples.R;
import com.antoniocappiello.oreo.samples.model.Sample;
import com.antoniocappiello.oreo.samples.model.SampleType;
import com.antoniocappiello.oreo.samples.view.notificationchannel.NotificationChannelsActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements ListItemViewHolder.InteractionListener {

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initList();
    }

    private void initList() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new SamplesListRecyclerViewAdapter(this, buildSampleList()));
    }

    @Override
    public void onItemClicked(SampleType sampleType) {
        switch (sampleType) {
            case NOTIFICATION_CHANNELS: {
                startActivity(new Intent(this, NotificationChannelsActivity.class));
                break;
            }
        }
    }

    public List<Sample> buildSampleList() {
        List<Sample> sampleList = new ArrayList<>();
        sampleList.add(
                new Sample(
                        SampleType.NOTIFICATION_CHANNELS,
                        getString(R.string.notification_channels),
                        getString(R.string.notification_channels_subtitle)));

        sampleList.add(
                new Sample(
                        SampleType.TODO, getString(R.string.notification_badges),
                        getString(R.string.todo)));

        sampleList.add(
                new Sample(
                        SampleType.TODO, getString(R.string.pinned_shortcuts),
                        getString(R.string.todo)));

        sampleList.add(
                new Sample(
                        SampleType.TODO, getString(R.string.downloadable_fonts),
                        getString(R.string.todo)));

        sampleList.add(
                new Sample(
                        SampleType.TODO, getString(R.string.autosizing_text_view),
                        getString(R.string.todo)));

        sampleList.add(
                new Sample(
                        SampleType.TODO, getString(R.string.picture_in_picture),
                        getString(R.string.todo)));

        sampleList.add(
                new Sample(
                        SampleType.TODO, getString(R.string.autofill_framework),
                        getString(R.string.todo)));

        sampleList.add(
                new Sample(
                        SampleType.TODO, getString(R.string.java_8_support),
                        getString(R.string.todo)));

        return sampleList;
    }
}
