package com.example.mystory;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(@Nullable Context context ) {
        super(context,"userdata.db", null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
DB.execSQL("create Table Userdetails (name TEXT primary key, Teller TEXT, Link TEXT, Rating Text) ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int ii) {
DB.execSQL("drop Table if exists Userdetails");
    }
    public Boolean insertuserdata (String Name, String Teller, String link, String Rating){

        SQLiteDatabase DB = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("name", Name);
        contentValues.put("Teller", Teller);
        contentValues.put("link", link);
        contentValues.put("Rating", Rating );
        long  result = DB.insert("Userdetails", null, contentValues);
        if (result == -1) {
            return false;

        }else{
           return true;

        }

    }
    public Cursor getdata(){

        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from Userdetails", null);
        return cursor;
    }
}
