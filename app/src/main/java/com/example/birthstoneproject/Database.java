package com.example.birthstoneproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database extends SQLiteOpenHelper {
    public static final String DBName = "Birthday_Database";
    public static final String TName = "Birthday";
    public static final String Col_1 = "Name";
    public static final String Col_2 = "Date";

    public Database(Context context) {
        super(context, DBName, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(" create table " + TName + "(" + Col_1 + " TEXT,"  + Col_2 + " TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TName);
        onCreate(db);
    }
    // function to add data into database
    public void addData(Birthday1 birthday){
        deleteData();
        SQLiteDatabase db=this.getWritableDatabase();
        db.execSQL("delete from "+ TName);
        ContentValues cv=new ContentValues();
        cv.put(Col_1,birthday.getName());
        cv.put(Col_2,birthday.getDate());
        db.insert(TName,null,cv);
        db.close();
    }

    // function to get data from database
    public Birthday1 getUserData(){
        Birthday1 birthday =new Birthday1();
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor = db.query(TName, null, null, null, null, null, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            birthday = new Birthday1 (cursor.getString(0),cursor.getString(1));
            cursor.moveToNext();
        }
        return birthday;
    }
    public void deleteData(){
        SQLiteDatabase db=this.getWritableDatabase();
        db.execSQL("delete from "+ TName);
    }
}
