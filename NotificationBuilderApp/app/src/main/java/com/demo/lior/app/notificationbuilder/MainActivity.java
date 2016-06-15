package com.demo.lior.app.notificationbuilder;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final Context cnt = getApplicationContext();
        final Button actAbt = (Button) findViewById(R.id.btActivityA);
        final Button actBbt = (Button) findViewById(R.id.btActivityB);
        final Button clearBtn = (Button) findViewById(R.id.clearBtn);

        actAbt.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intentA = new Intent(cnt, NotificationReceiverA.class);
                intentA.putExtra("Activity", "Notification_A");
                PendingIntent pIntentA = PendingIntent.getActivity(cnt, 0, intentA, PendingIntent.FLAG_UPDATE_CURRENT);

                NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

                try {
                    Thread.sleep(15000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                Notification notiA = new Notification.Builder(cnt)
                        .setContentTitle("A - Notification")
                        .setAutoCancel(true)
                        .setSmallIcon(R.drawable.icn)
                        .setContentIntent(pIntentA)
                        .setContentText("'A' notification").build();

                notificationManager.notify((int) System.currentTimeMillis(), notiA);

            }
        });


        actBbt.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intentB = new Intent(cnt, NotificationReceiverB.class);
                intentB.putExtra("Activity", "Notification_B");
                PendingIntent pIntentB = PendingIntent.getActivity(cnt, 0, intentB, PendingIntent.FLAG_UPDATE_CURRENT);

                NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

                try {
                    Thread.sleep(15000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                Notification notiB = new Notification.Builder(cnt)
                        .setContentTitle("B - Notification")
                        .setAutoCancel(true)
                        .setSmallIcon(R.drawable.icn)
                        .setContentIntent(pIntentB)
                        .setContentText("'B' notification").build();

                notificationManager.notify((int) System.currentTimeMillis(), notiB);
            }
        });

        clearBtn.setOnClickListener(new  View.OnClickListener() {

            @Override
            public void onClick(View v) {
                NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                System.out.println("clear button clicked");
                notificationManager.cancelAll();
            }
        });
    }

}
