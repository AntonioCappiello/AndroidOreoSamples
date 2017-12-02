package com.antoniocappiello.oreo.samples.view.notificationchannel;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.RadioGroup;

import com.antoniocappiello.oreo.samples.R;
import com.antoniocappiello.oreo.samples.utils.IntentUtils;

import java.util.Random;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by antonio on 30/11/2017.
 * <p>
 * Useful links to official documentation:
 * <p>
 * Notification:
 * https://developer.android.com/guide/topics/ui/notifiers/notifications.html
 * <p>
 * NotificationManager:
 * https://developer.android.com/reference/android/app/NotificationManager.html
 * <p>
 * NotificationChannel:
 * https://developer.android.com/reference/android/app/NotificationChannel.html
 * <p>
 * Butter Knife (view and resource binding library):
 * http://jakewharton.github.io/butterknife/
 */
public class NotificationChannelsActivity extends AppCompatActivity {

    private NotificationManager notificationManager;

    @BindView(R.id.channels_radio_group)
    RadioGroup channelsRadioGroup;

    @BindView(R.id.notification_message_et)
    EditText notificationMessageEt;

    @BindString(R.string.channel_one_id)
    String channelOneId;

    @BindString(R.string.channel_one_name)
    String channelOneName;

    @BindString(R.string.channel_two_id)
    String channelTwoId;

    @BindString(R.string.channel_two_name)
    String channelTwoName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_channels);
        ButterKnife.bind(this);
        setTitle(R.string.notification_channels);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        notificationManager = (NotificationManager) getApplicationContext()
                .getSystemService(Context.NOTIFICATION_SERVICE);

        // Prepare notification channels
        createChannel(channelOneId, channelOneName, NotificationManager.IMPORTANCE_DEFAULT);
        createChannel(channelTwoId, channelTwoName, NotificationManager.IMPORTANCE_HIGH);

        // Set default channel
        channelsRadioGroup.check(R.id.channel_1_radio_button);
    }

    /**
     * Create a new notification channel with the specified id.
     * <p>
     * A notification channel is "A representation of settings that apply to a collection of
     * similarly themed notifications."
     * Check the documentation for all possible settings of the NotificationChannel.
     * Ref: https://developer.android.com/reference/android/app/NotificationChannel.html
     * <p>
     * IMPORTANT NOTES:
     * Channel vibration and lights settings can only be modified before the channel is
     * submitted to NotificationManager.notify(String, int, Notification).
     * The reason for this is to prevent to spam the user.
     * Suppose that the user has disabled the notification for a specific channel. The notification
     * api doesn't allow the deleloper to delete and recreate the channel with different settings
     * to prevent to overrule the user preferences.
     * Ref: https://developer.android.com/reference/android/app/NotificationChannel.html#enableVibration(boolean)
     *
     * @param channelId
     * @param channelName
     * @param importance
     */
    private void createChannel(String channelId, String channelName, int importance) {
        NotificationChannel channel = new NotificationChannel(channelId, channelName, importance);
        channel.setLockscreenVisibility(Notification.VISIBILITY_PUBLIC);
        channel.enableVibration(true);
        channel.enableLights(true);
        channel.setShowBadge(true);
        channel.setDescription("It's nice for the user to explain what kind of notification will be shown into this channel");
        notificationManager.createNotificationChannel(channel);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @OnClick(R.id.send_button)
    public void onSendButtonClicked() {
        // Prepare notification parameters
        String channelId = getSelectedChannelId();
        int notificationId = getNotificationIdForChannel(channelId);
        String notificationTitle = getString(R.string.example_notification_in_channel, channelId);
        String notificationText = TextUtils.isEmpty(notificationMessageEt.getText()) ?
                getString(R.string.default_notification_text) :
                notificationMessageEt.getText().toString();

        // Build the notification
        Notification notification = new NotificationCompat.Builder(this, channelId)
                .setSmallIcon(R.drawable.ic_sms_black_24dp) // Vector icon created with android asset studio (https://www.youtube.com/watch?v=8e3I-PYJNHg)
                .setAutoCancel(true) // The notification is automatically canceled when the user clicks it
                .setUsesChronometer(true) // Just for fun
                .setContentTitle(notificationTitle)
                .setContentText(notificationText)
                .setContentIntent(IntentUtils.createOpenWebsiteIntent(this)) // Action to perform on click
                .build();

        // Show it
        notificationManager.notify(notificationId, notification);
    }

    /**
     * Simple utility method to return always the same "id" for the same channel so that when
     * posting the notification with this id then it is possible to replace the existing
     * notification.
     *
     * @param channelId
     * @return
     */
    private int getNotificationIdForChannel(String channelId) {
        if (channelId.equals(channelOneId)) {
            return 1;
        } else if (channelId.equals(channelTwoId)) {
            return 2;
        } else {
            return new Random().nextInt();
        }
    }

    private String getSelectedChannelId() {
        switch (channelsRadioGroup.getCheckedRadioButtonId()) {
            case R.id.channel_1_radio_button:
                return channelOneId;
            case R.id.channel_2_radio_button:
                return channelTwoId;
            default:
                return channelOneId;
        }
    }
}
