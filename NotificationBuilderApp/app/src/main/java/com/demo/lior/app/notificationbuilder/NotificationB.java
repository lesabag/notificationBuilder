package com.demo.lior.app.notificationbuilder;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class NotificationB extends Activity {

    String str;
    private String TAG = getPackageName() + "_" + getLocalClassName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_receiver_b);
    }

    @Override
    protected void onStart() {
        Log.i(TAG, "activityB started");
        super.onStart();

        final TextView tv = (TextView)findViewById(R.id.tv);
        String value = null;

        Bundle extras = getIntent().getExtras();//getStringExtra (key)- bring the value directly from the key, if is unnecessary
        if (extras != null)
        {
            value = extras.getString("Activity");
            tv.setText(value);

            Log.i(TAG, "activity Name = " + value);
        }
        else
        {
            Log.i(TAG, "activity Name = " + value);
        }

    }
}
