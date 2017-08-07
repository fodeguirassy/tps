package com.furkilic.tpasync;

import android.os.AsyncTask;
import android.util.Log;

/**
 * Created by furki on 24/05/2017.
 */

public class MyAsyncTask extends AsyncTask<Long,Long,Long> {

    MainActivity mainActivity;

    public MyAsyncTask(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    //UI-THREAD
    @Override
    protected void onPreExecute() {
        Log.i("MyAsyncTask","onPreExecute");
        super.onPreExecute();
    }

    //ASYNCHRONE
    // @Override
    protected Long doInBackground(Long... params) {
        Long max = params[0];
        long increment =0;
        while(increment<max){
            increment++;
            if(0==increment%100){
                //TODO: UPDATE
                publishProgress(increment);
            }
        }
        return max;
    }

    //UI-THREAD
    @Override
    protected void onProgressUpdate(Long... values) {
        Long current=values[0];
        mainActivity.updateTextView(current);
    }

    //UI-THREAD
    @Override
    protected void onPostExecute(Long max) {
        mainActivity.updateTextView(max);
    }
}
