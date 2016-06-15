package com.demo.lior.app.notificationbuilder;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class NotificationReceiverA extends Activity {

    String str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_receiver);

        //str = tv.getText().toString();
    }

    @Override
    protected void onStart() {
        System.out.println("activityA started");
        super.onStart();

        final TextView tv = (TextView)findViewById(R.id.tv);//called from textView

        String value = null;

        Bundle extras = getIntent().getExtras();//getStringExtra (key)- bring the value directly from the key, if is unnecessary
        if (extras != null)
        {
            value = extras.getString("Activity");
            tv.setText(value);

            System.out.println("activity Name = " + value);
        }
        else
        {
            System.out.println("activity Name = " + value);
        }

    }
}
