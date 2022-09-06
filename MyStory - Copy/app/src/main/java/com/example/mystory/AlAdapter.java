package com.example.mystory;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.imageview.ShapeableImageView;

import java.util.List;

public class AlAdapter extends ArrayAdapter {
List <Story> list;
    public AlAdapter(@NonNull Context context, int resource, @NonNull List objects) {
        super(context, resource, objects);
        list = objects;
    }

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.item_bar, parent, false);

        Story StoryNow = list.get(position);


        TextView TVteller = (TextView) view.findViewById(R.id.StoryName3);
        TextView TVname = (TextView) view.findViewById(R.id.txtname);

        ShapeableImageView storyimg = (ShapeableImageView) view.findViewById(R.id.storyimg);

        TVname.setText(StoryNow.getStoryName());
        TVteller.setText(StoryNow.getStoryTeller());
        storyimg.setImageResource(StoryNow.getStoryTellerIMG());

        return view ;
    }
}

