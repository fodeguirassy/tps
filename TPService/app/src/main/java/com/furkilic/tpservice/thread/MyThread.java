package com.furkilic.tpservice.thread;

import android.util.Log;

public class MyThread extends Thread {

    public MyThread() {
        super();
    }

    @Override
    public void run() {
        super.run();
        for(int i=0; i<10000000;i++){
            if(i%1000 == 0) {
                Log.i("MyThread","count to : "+i);
            }
        }
    }


    public static void main(String[] args){
        Thread thread = new MyThread();
        // PAS BIEN : thread.run();
        thread.start();

    }















}
