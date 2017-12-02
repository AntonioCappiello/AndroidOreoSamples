package com.antoniocappiello.oreo.samples.model;

/**
 * Created by antonio on 30/11/2017.
 */

public class Sample {
    String title;
    String subtitle;
    private SampleType type;

    public Sample(SampleType type, String title, String subtitle) {
        this.type = type;
        this.title = title;
        this.subtitle = subtitle;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public SampleType getType() {
        return type;
    }
}
