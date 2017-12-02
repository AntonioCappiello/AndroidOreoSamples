package com.antoniocappiello.oreo.samples.utils;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

/**
 * Created by antonio on 01/12/2017.
 */

public class IntentUtils {
    private IntentUtils() {
        //no instance
    }

    public static PendingIntent createOpenWebsiteIntent(Context context) {
        String url = "https://antoniocappiello.com/";
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        return PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_ONE_SHOT);
    }
}
