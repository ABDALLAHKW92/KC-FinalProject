package com.example.mystory;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter <MyAdapter.MyViewHolder> {
    private Context context;
    private ArrayList Name_id, teller_id,link_id,rating_id;

    public MyAdapter(Context context, ArrayList name_id, ArrayList teller_id, ArrayList link_id, ArrayList rating_id) {
        this.context = context;
        Name_id = name_id;
        this.teller_id = teller_id;
        this.link_id = link_id;
        this.rating_id = rating_id;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context).inflate(R.layout.recycler_row, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
holder.name_id.setText(String.valueOf(Name_id.get(position)));
        holder.teller_id.setText(String.valueOf(teller_id.get(position)));
        holder.rating_id.setText(String.valueOf(rating_id.get(position)));
    }

    @Override
    public int getItemCount() {
        return Name_id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name_id, teller_id, rating_id;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name_id = itemView.findViewById(R.id.StoryName3);
           teller_id = itemView.findViewById(R.id.Storyteller4);
           rating_id= itemView.findViewById(R.id.Ratings);
        }
    }
}
