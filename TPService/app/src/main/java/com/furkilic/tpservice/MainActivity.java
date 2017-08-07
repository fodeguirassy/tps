package com.furkilic.tpservice;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private MyService.MyBinder myBinder;
    private boolean isBinded = false;
    private ServiceConnection myServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            myBinder = (MyService.MyBinder) service;
            isBinded = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            isBinded = false;
        }
    };

    private void bindMyService() {
        if (!isBinded) {
            Intent intent = new Intent(this, MyService.class);
            bindService(intent, myServiceConnection, BIND_AUTO_CREATE);
        }else {
            long increment = myBinder.getCurrentIncrement();
            Toast.makeText(this, "Increment = " + increment, Toast.LENGTH_SHORT).show();
        }
    }

    private void unbindMyService() {
        if (isBinded) {
            unbindService(myServiceConnection);
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button startButton = (Button) findViewById(R.id.startService);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startMyService();
            }
        });

        Button bindButton = (Button) findViewById(R.id.bindService);
        bindButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bindMyService();
            }
        });

        Button unbindButton = (Button) findViewById(R.id.unbindService);
        unbindButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                unbindMyService();
            }
        });
    }


    private void startMyService() {
        Intent intent = new Intent(this, MyService.class);
        startService(intent);
    }

    public void stopMyService(View view) {
        Intent intent = new Intent(this, MyService.class);
        stopService(intent);

    }
}
