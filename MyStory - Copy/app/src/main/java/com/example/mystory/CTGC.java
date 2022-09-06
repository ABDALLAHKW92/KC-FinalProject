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

public class CTGC extends AppCompatActivity {

    ArrayList <Story> AMDARRAY = new ArrayList<>();
    int current = 0 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ctgc);

        getSupportActionBar().hide();
// bundle and the friends
        Bundle bundle = getIntent().getExtras();

        Story AMD1 = (Story) bundle.get("AMD1");
        Story AMD2 = (Story) bundle.get("AMD2");
        Story AMD3 = (Story) bundle.get("AMD3");
        Story AMD4 = (Story) bundle.get("AMD4");
        Story AMD5 = (Story) bundle.get("AMD5");

        AMDARRAY.add(AMD1);
        AMDARRAY.add(AMD2);
        AMDARRAY.add(AMD3);
        AMDARRAY.add(AMD4);
        AMDARRAY.add(AMD5);


// تعريفات
        CardView cv = findViewById(R.id.CV);


        TextView Next = findViewById(R.id.nextext);
        TextView before = findViewById(R.id.backtext);
        TextView name = findViewById(R.id.nametext2);
        TextView Length = findViewById(R.id.lengthText2);
        TextView Category = findViewById(R.id.CategoryText2);
        Button  watch = cv.findViewById(R.id.watchbutton);


        name.setText(AMDARRAY.get(current).getStoryName());
        Length.setText(String.valueOf(AMDARRAY.get(current).getStoryLength()) + "دقيقة");
        Category.setText(AMDARRAY.get(current).getStoryCategory());



        Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                current ++ ;
                if (current == AMDARRAY.size()) {

                    current = 0 ;

                }

                name.setText(AMDARRAY.get(current).getStoryName());
                Length.setText(String.valueOf(AMDARRAY.get(current).getStoryLength()) + "دقيقة");
                Category.setText(AMDARRAY.get(current).getStoryCategory());





            }
        });
before.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
current -- ;
        if (current < 0 ) {

            current = 4 ;

        }
        name.setText(AMDARRAY.get(current).getStoryName());
        Length.setText(String.valueOf(AMDARRAY.get(current).getStoryLength())+ "دقيقة");
        Category.setText(AMDARRAY.get(current).getStoryCategory());
    }
});
watch.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        String Link = AMDARRAY.get(current).getStoryLink();
        intent.setData(Uri.parse(Link));
        startActivity(intent);
    }
});
    }
}