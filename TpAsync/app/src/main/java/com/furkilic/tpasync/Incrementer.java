package com.furkilic.tpasync;

/**
 * Created by furki on 24/05/2017.
 */

public class Incrementer extends Thread {

    long max;
    MainActivity mainActivity;

    public Incrementer(MainActivity mainActivity,long max) {
        this.max = max;
        this.mainActivity=mainActivity;
    }

    @Override
    public void run() {
        long increment =0;
        while(increment<max){
            increment++;
            if(0==increment%100){
                //TODO: UPDATE
                final long tmp=increment;
               mainActivity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mainActivity.updateTextView(tmp);
                    }
                });
            }
        }
        //TODO:UPDATE VIEW FINISH
    }
}
