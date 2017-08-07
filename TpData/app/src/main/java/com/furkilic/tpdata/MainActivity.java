package com.furkilic.tpdata;

import android.content.ContentValues;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    public static final String LAST_CONNECTED_DATE = "LAST_CONNECTED_DATE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sharedPreferences = getPreferences(MODE_APPEND);
        long lastConnectedDate =sharedPreferences.getLong(LAST_CONNECTED_DATE,-1);
        if(-1==lastConnectedDate){
            Toast.makeText(this, "Welcome to My Application", Toast.LENGTH_SHORT).show();
        }else{
            Date date = new Date(lastConnectedDate);
            Toast.makeText(this, "Connected Last Time the "+date, Toast.LENGTH_SHORT).show();
        }
        Date now = new Date();
        sharedPreferences.edit().putLong(LAST_CONNECTED_DATE,now.getTime()).commit();
    }

    public void onWriteCacheClick(View view){
        try {
            File cacheDir = getCacheDir();
            File cacheFile = new File(cacheDir.getAbsoluteFile() + "/cache_test.txt");
            FileOutputStream fos = new FileOutputStream(cacheFile,true);
            writeInFile(fos);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void onReadCacheClick(View view){
        try {
            File cacheDir = getCacheDir();
            File cacheFile = new File(cacheDir.getAbsoluteFile() + "/cache_test.txt");
            FileInputStream fis = new FileInputStream(cacheFile);
            String content = readFromFile(fis);
            Toast.makeText(this, content, Toast.LENGTH_SHORT).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void onWriteFileClick(View view){
        try {
            FileOutputStream fos = openFileOutput("myfile.txt",MODE_APPEND);
            writeInFile(fos);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void onReadFileClick(View view){
        try { FileInputStream fis = openFileInput("myfile.txt");
            String content = readFromFile(fis);
            Toast.makeText(this, content, Toast.LENGTH_SHORT).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }



    public void writeInFile(FileOutputStream fileOutputStream){
        try {
            fileOutputStream.write("HELLO CACHE".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public  String readFromFile(FileInputStream fileInputStream){
        try{
            String content="";
            BufferedReader reader = new BufferedReader(new InputStreamReader(fileInputStream));
            String line = null;
            while((line=reader.readLine())!=null){
                content+=line+"\n";
            }
            return content;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }


    private void databaseTest(){
        DataBaseHelper dataBaseHelper = new DataBaseHelper(this,DataBaseHelper.DB_NAME,null,DataBaseHelper.DB_VERSION);
        SQLiteDatabase db;
        try{
            db = dataBaseHelper.getWritableDatabase();
        }catch (SQLiteException e){
            db = openOrCreateDatabase(DataBaseHelper.DB_NAME,MODE_PRIVATE,null);
        }
        //INSERT
        ContentValues toInsert = new ContentValues();
        toInsert.put("label","Leon");
        long idInserted = db.insert("STUDENT",null,toInsert);
        Log.i("SQL", "INSERTED ID = "+idInserted);

        //UPDATE
        ContentValues toUpdate = new ContentValues();
        toUpdate.put("label", "Nicolas");
        long nbUpdated = db.update("STUDENT",toUpdate," _ID = ? ",new String[]{String.valueOf(idInserted)});
        Log.i("SQL", "Nb Updated element =  "+nbUpdated);

        //DELETE
        long nbDelete = db.delete("STUDENT"," _ID = ? ", new String[]{String.valueOf(idInserted)})
        Log.i("SQL", "Nb Deleted element =  "+nbDelete);

        //SELECT
        Cursor cursor = db.query("STUDENT",null,null,null,null,null,"label");
        while(cursor.moveToNext()){
            long id = cursor.getLong(cursor.getColumnIndex("_ID"));
            String label =cursor.getString(cursor.getColumnIndex("label"));
        }




    }

















}
