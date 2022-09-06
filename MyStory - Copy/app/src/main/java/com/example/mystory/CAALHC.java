package com.example.mystory;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.time.Year;
import java.util.ArrayList;

public class CAALHC extends AppCompatActivity {
    ArrayList<Story> AALHARRAY = new ArrayList<>();
    int current = 0 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caalhc);
        getSupportActionBar().hide();
// bundle and the friends
        Bundle bundle = getIntent().getExtras();

        Story AALH1 = (Story) bundle.get("AALH");
        Story AALH2 = (Story) bundle.get("AALH2");
        Story AALH3 = (Story) bundle.get("AALH3");
        Story AALH4 = (Story) bundle.get("AALH4");


       AALHARRAY.add(AALH1);
        AALHARRAY.add(AALH2);
       AALHARRAY.add(AALH3);
       AALHARRAY.add(AALH4);
        // تعريفات
        CardView cv = findViewById(R.id.CV);


        TextView Next = findViewById(R.id.nextext);
        TextView before = findViewById(R.id.backtext);
        TextView name = findViewById(R.id.nametext2);
        TextView Length = findViewById(R.id.lengthText2);
        TextView Category = findViewById(R.id.CategoryText2);
        Button watch = cv.findViewById(R.id.watchbutton);


        name.setText(AALHARRAY.get(current).getStoryName());
        Length.setText(String.valueOf(AALHARRAY.get(current).getStoryLength()) + "دقيقة");
        Category.setText(AALHARRAY.get(current).getStoryCategory());


        Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                current ++ ;
                if (current == AALHARRAY.size()) {

                    current = 0 ;

                }

                name.setText(AALHARRAY.get(current).getStoryName());
                Length.setText(String.valueOf(AALHARRAY.get(current).getStoryLength()) + "دقيقة");
                Category.setText(AALHARRAY.get(current).getStoryCategory());





            }
        });
        before.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                current -- ;

                if (current < 0 ){

                    current = 3 ;
                }
                name.setText(AALHARRAY.get(current).getStoryName());
                Length.setText(String.valueOf(AALHARRAY.get(current).getStoryLength())+ "دقيقة");
                Category.setText(AALHARRAY.get(current).getStoryCategory());
            }
        });
        watch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                String Link = AALHARRAY.get(current).getStoryLink();
                intent.setData(Uri.parse(Link));
                startActivity(intent);
            }
        });
    }
}
