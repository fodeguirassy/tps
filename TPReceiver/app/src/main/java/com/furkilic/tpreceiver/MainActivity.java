package com.furkilic.tpreceiver;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private MyReceiver myReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button broadcastButton = (Button) findViewById(R.id.broadcast);
        broadcastButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                broadcastSomething();
            }
        });

        myReceiver = new MyReceiver();
        registerReceiver(myReceiver,new IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED));
    }
    private void broadcastSomething() {
        //Intent intent= new Intent(this, MyReceiver.class);
        Intent intent = new Intent("ACTION_FOR_MY_RECEIVER");
        sendBroadcast(intent);
    }
    @Override
    protected void onDestroy() {
        unregisterReceiver(myReceiver);
        super.onDestroy();
    }



}
