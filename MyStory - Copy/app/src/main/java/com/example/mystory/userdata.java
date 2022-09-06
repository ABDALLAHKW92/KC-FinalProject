package com.example.mystory;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class userdata extends AppCompatActivity {
    ArrayList<String> name, teller,link, Ratings;
    RecyclerView RV;
    MyAdapter Adapter;
    DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_userdata);
        getSupportActionBar().hide();
    DB = new DBHelper(this);
name = new ArrayList<>();
        teller= new ArrayList<>();
        link = new ArrayList<>();
        Ratings = new ArrayList<>();
        RV = findViewById(R.id.RV);
        Adapter = new MyAdapter(this, name, teller, link, Ratings);
        RV.setAdapter(Adapter);
        RV.setLayoutManager(new LinearLayoutManager(this));
        displaydata();
}

    private void displaydata() {

      Cursor cursor = DB.getdata();
      if (cursor.getCount()==0){

          Toast.makeText(userdata.this, "could not load data", Toast.LENGTH_SHORT ).show();
          return;

      }else{
          while (cursor.moveToNext()){
              name.add(cursor.getString(0));
              teller.add(cursor.getString(1));
              link.add(cursor.getString(2));
              Ratings.add(cursor.getString(3));
          }
      }

    }
}

