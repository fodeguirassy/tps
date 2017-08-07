package com.furkilic.tpreceiver;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "Action "+ intent.getAction(), Toast.LENGTH_SHORT).show();

        PendingIntent empty = PendingIntent.getActivity(context,0,new Intent(),PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder notifBuilder = new NotificationCompat.Builder(context);
        Notification notif = notifBuilder
                                .setContentIntent(empty)
                                .setSmallIcon(R.mipmap.ic_launcher_round)
                                .setContentTitle("Notif Title")
                                .setContentText(intent.getAction())
                                .build();
        NotificationManager notificationManager =
                (NotificationManager) context.getSystemService(context.NOTIFICATION_SERVICE);
        notificationManager.notify(intent.getAction().hashCode(),notif);
    }













}
