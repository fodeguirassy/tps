package com.furkilic.tpdata;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by furki on 24/05/2017.
 */

public class DataBaseHelper extends SQLiteOpenHelper {

    public final static String DB_NAME="esgi";
    public final static int DB_VERSION=1;

    public DataBaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    private static final String CREATE_STUDENT_TABLE=
            "CREATE TABLE STUDENT (_ID INTEGER PRIMARY KEY AUTOINCREMENT, LABEL VARCHAR)";

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_STUDENT_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //TODO: DURING AN UPGRADE
    }
}
