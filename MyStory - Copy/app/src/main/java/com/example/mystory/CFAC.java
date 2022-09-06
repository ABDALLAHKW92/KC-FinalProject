package com.example.mystory;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class CFAC extends AppCompatActivity {

    ArrayList<Story> FAARRAY = new ArrayList<>();
    int current = 0 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cfac);

        getSupportActionBar().hide();
// bundle and the friends
        Bundle bundle = getIntent().getExtras();

        Story FA1 = (Story) bundle.get("FA1");
        Story FA2 = (Story) bundle.get("FA2");
        Story FA3 = (Story) bundle.get("FA3");
        Story FA4 = (Story) bundle.get("FA4");
        Story FA5 = (Story) bundle.get("FA5");

        FAARRAY.add(FA1);
       FAARRAY.add(FA2);
        FAARRAY.add(FA3);
        FAARRAY.add(FA4);
        FAARRAY.add(FA5);


        // تعريفات
        CardView cv = findViewById(R.id.CV);


        TextView Next = findViewById(R.id.nextext);
        TextView before = findViewById(R.id.backtext);
        TextView name = findViewById(R.id.nametext2);
        TextView Length = findViewById(R.id.lengthText2);
        TextView Category = findViewById(R.id.CategoryText2);
        Button watch = cv.findViewById(R.id.watchbutton);


        name.setText(FAARRAY.get(current).getStoryName());
        Length.setText(String.valueOf(FAARRAY.get(current).getStoryLength()) + "دقيقة");
        Category.setText(FAARRAY.get(current).getStoryCategory());



        Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                current ++ ;
                if (current == FAARRAY.size()) {

                    current = 0 ;

                }

                name.setText(FAARRAY.get(current).getStoryName());
                Length.setText(String.valueOf(FAARRAY.get(current).getStoryLength()) + "دقيقة");
                Category.setText(FAARRAY.get(current).getStoryCategory());





            }
        });
        before.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                current -- ;
                if (current < 0 ) {

                    current = 4 ;

                }
                name.setText(FAARRAY.get(current).getStoryName());
                Length.setText(String.valueOf(FAARRAY.get(current).getStoryLength())+ "دقيقة");
                Category.setText(FAARRAY.get(current).getStoryCategory());
            }
        });
        watch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                String Link = FAARRAY.get(current).getStoryLink();
                intent.setData(Uri.parse(Link));
                startActivity(intent);
            }
        });
    }
}