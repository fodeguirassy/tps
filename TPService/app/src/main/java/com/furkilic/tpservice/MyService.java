package com.furkilic.tpservice;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.util.Log;

import com.furkilic.tpservice.thread.IncrementerThread;
import com.furkilic.tpservice.thread.MyThread;

public class MyService extends Service {
    private IncrementerThread myThread ;

    public MyService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        myThread = new IncrementerThread();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        myThread.start();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Log.i(this.getClass().getCanonicalName(), "Destroy");
        myThread.interrupt();
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
      return new MyBinder();
    }
    @Override
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }

    public class MyBinder extends Binder{
        public long getCurrentIncrement(){
            return myThread.getIncrement();
        }
    }






}
