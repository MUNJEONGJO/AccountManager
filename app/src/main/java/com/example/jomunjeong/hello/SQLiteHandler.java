package com.example.jomunjeong.hello;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by jomunjeong on 2015. 11. 29..
 */
public class SQLiteHandler {

    SQLiteHelper helper;
    SQLiteDatabase db;


    private static final String TABLE_tblMaster = "tblMaster";
    private static final String TABLE_tblAccount = "tblAccount";

    // 초기화 작업
    public SQLiteHandler(Context context) {
        helper = new SQLiteHelper(context);
    }


    //open
    public static SQLiteHandler open(Context context) {
        return new SQLiteHandler(context);
    }

    //close
    public void close() {
        db.close();
    }

    //저장
    public void insert_Account(Account account) {
        db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("siteName", account.siteName);
        values.put("url", account.url);
        values.put("id", account.id);
        values.put("pw", account.pw);
        db.insert(TABLE_tblAccount, null, values);
    }//end insert



    public void insert_update_Master(String pw){

        db = helper.getWritableDatabase();
        String query = "INSERT OR REPLACE INTO " + TABLE_tblMaster + " (masterIdx, pw) VALUES (1, '" + pw + "')";
        db.execSQL(query);
        db.close();
    }

    //수정
    public void update(String name, int age) {
        db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("age", age);
        db.update("person", values, "name=?", new String[]{name});
    }//end update

    //삭제
    public void delete(String name) {
        db = helper.getWritableDatabase();
        db.delete("person", "name=?", new String[]{name});
    }//end delete

    //검색
    public Cursor select_Account() {
        db = helper.getReadableDatabase();
        Cursor c = db.query(TABLE_tblAccount, null, null, null, null, null, null);
        return c;
    }//end select

    //검색
    public Cursor select_Master() {
        db = helper.getReadableDatabase();
        Cursor c = db.query(TABLE_tblMaster, null, null, null, null, null, null);
        return c;
    }//end select
}
