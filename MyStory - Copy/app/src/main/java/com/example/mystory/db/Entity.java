package com.example.mystory.db;

import androidx.room.ColumnInfo;
import androidx.room.PrimaryKey;

@androidx.room.Entity
public class Entity {
    @PrimaryKey (autoGenerate = true)

    public int uid ;
@ColumnInfo (name = "Story_name")
    public String StoryName;
    @ColumnInfo (name = "Story_Link")
    public String StoryLink;
    @ColumnInfo (name = "Teller_name")
    public String TellerName;
    @ColumnInfo (name = "Rating")
    public int rating;
}
