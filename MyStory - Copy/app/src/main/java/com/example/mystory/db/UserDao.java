package com.example.mystory.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserDao {

    @Query("SELECT * FROM Entity")
    List<Entity> getAllUsers();

    @Insert
    void insertStory (Entity... users);

    @Delete
    void delete (Entity user);
}
