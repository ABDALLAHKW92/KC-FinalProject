package com.example.mystory;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class StoryCategoryChoosen extends AppCompatActivity {
ArrayList <Story> Horror = new ArrayList<>();
    ArrayList <Story> sad = new ArrayList<>();
    ArrayList <Story> crime = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story_category_choosen);

getSupportActionBar().hide();
        Button horror = findViewById(R.id.Horror);
        Button sad2 = findViewById(R.id.Sad);
        Button crime2 = findViewById(R.id.crime);



        Story AMD1 = new Story("السلف السابع ( بيت الوادي )", 47, "رعب-جن", "", "أحمد الشمري",
                "https://www.youtube.com/watch?v=tHAcfqSOf7k", R.drawable.channels4_profile__1_);


        Story AMD2 = new Story("روح القمر ", 49, "رعب-جن", "", "أحمد الشمري",
                "https://www.youtube.com/watch?v=b3w_-xPChFM", R.drawable.channels4_profile__1_);

        Story AMD3 = new Story("بدايه الرعب ", 37, "رعب-جن", "", "أحمد الشمري",
                "https://www.youtube.com/watch?v=kDIw-ZZ5upo", R.drawable.channels4_profile__1_);


        Story AMD4 = new Story("قصتي مع ملك الجن ", 39, "رعب-جن", "", "أحمد الشمري",
                "https://www.youtube.com/watch?v=cxeHjk5wuMY", R.drawable.channels4_profile__1_);

        Story AMD5 = new Story("طريق الجنوب  ", 33, "رعب-جن", "", "أحمد الشمري",
                "https://www.youtube.com/watch?v=7GaQnZh82b8", R.drawable.channels4_profile__1_);




        Story FA1 = new Story("مصيبة في بحر الكويت", 31, "جريمة", "", "فارس عاشور",
                "https://www.youtube.com/watch?v=CJlblCf-lZE&list=PL-2dz0Bme9f8AJjXXcs7PJyG-UKGhryRr", R.drawable.channels4_profile);

        Story FA2 = new Story("وحش الكويت .. وحش حولي", 18, "جريمة", "", "فارس عاشور",
                "https://www.youtube.com/watch?v=eVdqqqC_rkM", R.drawable.channels4_profile);

        Story AALH3 = new Story("525 - قصه 150 ألف دولار!", 60, "جريمة-عبرة", "", "ابو طلال الحمراني",
                "https://www.youtube.com/watch?v=C9-BHUyBNgo", R.drawable.uhr9phho_400x400__1_);
        Story FA4 = new Story("القضية التي لن تموت في العراق", 16, "جريمة-حرب-حزينة", "", "فارس عاشور",
                "https://www.youtube.com/watch?v=U5dRNBQZeQA", R.drawable.channels4_profile);

        Story AALH4 = new Story("260 - قصة جهيمان واقتحام الحرم المكي الشريف", 39, "جريمة -أكشن", "", "ابو طلال الحمراني",
                "https://www.youtube.com/watch?v=S2-Ndiek-HE", R.drawable.uhr9phho_400x400__1_);

        Story AZ1 = new Story ( "اجيج الوصب..", 82, "حزينة-رعب-جن", "", "عيزوز",
                "https://www.youtube.com/watch?v=XzNw6Z2BiVA", R.drawable.unnamed);

        Horror.add(AMD1);
        Horror.add(AMD2);
        Horror.add(AMD3);
        Horror.add(AMD4);
        Horror.add(AMD5);


        sad.add(FA4);
        sad.add(AZ1);


        crime.add(FA1);
        crime.add(FA2);
        crime.add(FA4);
        crime.add(AALH4);
        crime.add(AALH3);

        AlAdapter Horror2 = new AlAdapter(this, 0 , Horror);
        AlAdapter crime3 = new AlAdapter(this, 0 , crime);
        AlAdapter sad4 = new AlAdapter(this, 0 , sad);
        ListView LV=  findViewById(R.id.LV);

        sad2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LV.setAdapter(sad4 );
                LV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                        Story nowSad = sad.get(i);
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        String link5 =nowSad.getStoryLink();
                        intent.setData(Uri.parse(link5));
                        startActivity(intent);
                    }
                });
            }
        });





        crime2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LV.setAdapter(crime3);
                LV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                        Story nowCrime = crime.get(i);
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        String link3 =nowCrime.getStoryLink();
                        intent.setData(Uri.parse(link3));
                        startActivity(intent);
                    }
                });
            }
            });






        horror.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LV.setAdapter(Horror2);
                LV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                        Story nowHorror = Horror.get(i);
                         Intent intent = new Intent(Intent.ACTION_VIEW);
                        String link4 =nowHorror.getStoryLink();
                        intent.setData(Uri.parse(link4));
                        startActivity(intent);
            }
        });
            }
        });




    }
}