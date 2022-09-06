package com.example.mystory;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.mystory.db.Entity;

import java.util.List;

public class RoomAdapter extends ArrayAdapter {

    List <Entity> list;


    public RoomAdapter(@NonNull Context context, int resource, @NonNull List objects) {
        super(context, resource, objects);
        list = objects;
    }

  //  @NonNull
 //           @Override
   // public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//return
   // }
}
