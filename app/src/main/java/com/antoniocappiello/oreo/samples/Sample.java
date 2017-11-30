package com.antoniocappiello.oreo.samples;

/**
 * Created by antonio on 30/11/2017.
 */

class Sample {
    String title;
    String subtitle;

    public Sample(String title, String subtitle) {
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
}
