package com.example.jomunjeong.hello;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by jomunjeong on 2015. 11. 16..
 */
public class SQLiteHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "DB.db";


    private static final String CREATE_tblMaster_TABLE = "CREATE TABLE IF NOT EXISTS tblMaster ( " +
            "masterIdx INTEGER PRIMARY KEY, " +
            "pw TEXT )";

    private static final String CREATE_tblAccount_TABLE = "CREATE TABLE IF NOT EXISTS tblAccount ( " +
            "accountIdx INTEGER PRIMARY KEY, " +
            "siteName TEXT, " +
            "url TEXT, " +
            "id TEXT, " +
            "pw Text)";

    public SQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_tblMaster_TABLE);
        db.execSQL(CREATE_tblAccount_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
