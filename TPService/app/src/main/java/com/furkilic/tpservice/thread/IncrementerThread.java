package com.furkilic.tpservice.thread;


import android.util.Log;

import java.util.concurrent.atomic.AtomicBoolean;

public class IncrementerThread extends Thread {

    public static final String INCREMENTER_TAG = "IncrementerThread";
    private long increment = 0;
    private AtomicBoolean interrupted= new AtomicBoolean(false);

    public long getIncrement() {
        return increment;
    }

    @Override
    public void run() {
        while(!interrupted.get()){
            if(increment%1000 == 0){
                Log.i(INCREMENTER_TAG,"Incrementer = "+increment);
            }
            increment++;
        }
    }
    @Override
    public void interrupt() {
        interrupted.set(true);
        super.interrupt();
    }
}
