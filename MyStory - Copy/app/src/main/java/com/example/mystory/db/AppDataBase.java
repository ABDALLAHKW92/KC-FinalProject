package com.example.mystory.db;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;


@Database(entities  = {Entity.class}, version = 1)
public abstract class  AppDataBase extends RoomDatabase {

    public abstract UserDao userdao();
    private static AppDataBase INSTANCE;

    public static AppDataBase getdbINSTANCE (Context context) {
if (INSTANCE == null) {

INSTANCE = Room.databaseBuilder(context.getApplicationContext(), AppDataBase.class, "UserStoryDB").allowMainThreadQueries().build();

}
return  INSTANCE;
    }
    }

