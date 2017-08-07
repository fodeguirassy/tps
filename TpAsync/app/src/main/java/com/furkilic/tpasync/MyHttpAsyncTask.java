package com.furkilic.tpasync;

import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.Date;

/**
 * Created by furki on 24/05/2017.
 */

public class MyHttpAsyncTask extends AsyncTask<String, Long, String> {

    MainActivity mainActivity;

    public MyHttpAsyncTask(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Override
    protected String doInBackground(String... params) {
        String content ="";
        try {
            URL url = new URL(params[0]);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setConnectTimeout(1000);
            httpURLConnection.setReadTimeout(2000);
            httpURLConnection.setRequestMethod("GET");

            Log.i("MyHttpAsync", " Connecting ...");
            httpURLConnection.connect();
            Log.i("MyHttpAsync", "REsponse code : "+ httpURLConnection.getResponseCode());

            InputStream is = httpURLConnection.getInputStream();
          /*  OLD FASHION
          BufferedReader reader = new BufferedReader(new InputStreamReader(is));

            String line = null;
            while((line=reader.readLine())!=null){
                content+=line+"\n";
                publishProgress(Long.valueOf(content.length()));
            }

            reader.close();*/

            User[] users = new Gson().fromJson(new InputStreamReader(is), User[].class);

            content = Arrays.asList(users).toString();
            is.close();
            httpURLConnection.disconnect();
        }catch (MalformedURLException e){
            content =params[0]+" is not an URL ";
        } catch (IOException e) {
            content ="Connection error";
            e.printStackTrace();
        }
        return content;
    }

    @Override
    protected void onProgressUpdate(Long... values) {
        mainActivity.updateTextView(values[0]);
    }

    @Override
    protected void onPostExecute(String s) {
        mainActivity.updateContent(s);
    }
}
