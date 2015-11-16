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

    private static final String TABLE_tblAccount = "tblAccount";

    private static final String CREATE_tblAccount_TABLE = "CREATE TABLE IF NOT EXISTS tblAccount ( " +
            "accountIdx INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "pw TEXT )";

    public SQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_tblAccount_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insertTblAccount(String pw){
        String query = "INSERT INTO " + TABLE_tblAccount + " (pw) VALUES ('" + pw + "')";

        SQLiteDatabase db = this.getWritableDatabase();

        db.execSQL(query);
        db.close();
    }
}
