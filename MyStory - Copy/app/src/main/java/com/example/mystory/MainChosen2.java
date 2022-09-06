package com.example.mystory;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.google.android.material.imageview.ShapeableImageView;

import java.util.ArrayList;
import java.util.Random;

public class MainChosen2 extends AppCompatActivity {
    ArrayList<Story> RandomListDatabase = new ArrayList<>();

    ArrayList<Story> Featured = new ArrayList<>();
    int one;
    int two;
    int three;
    int five = 0 ;


    TextView tellerweektv  ;
    TextView storyweektv ;
    ShapeableImageView weekimg ;
    CardView weekq;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_chosen2);






        getSupportActionBar().hide();

        //  random button تعريفات الكائنات



        ShapeableImageView Randombutton = findViewById(R.id.button3);

// تعريف كائنات random results

        CardView Randomresult = findViewById(R.id.randomcard);

        TextView RandomNameTV = Randomresult.findViewById(R.id.randomStoryName);
        TextView tellerTV = Randomresult.findViewById(R.id.randomstoryteller);
        ShapeableImageView RandomIMG = Randomresult.findViewById(R.id.randomtellerimage);


        // تعريف كائنات story of the session

        CardView sessioncard = findViewById(R.id.daycard);

        TextView NameTv2 = findViewById(R.id.daystoryname);
        TextView tellerTv2 = findViewById(R.id.daytvtellername);
        ShapeableImageView Dayimg = findViewById(R.id.sessionstoryimg);


        // نعرف الbuttons اللي فوق
        CardView Navi = findViewById(R.id.UpCV);

        Button CTGC = Navi.findViewById(R.id.CTGC);
        Button CFAC = Navi.findViewById(R.id.CFAC);
        Button CAALHC = Navi.findViewById(R.id.CAALHC);


        // تعريف ال Featured (after story of the week was a bad idea)
         weekq = (CardView) findViewById(R.id.horror1);

        tellerweektv = weekq.findViewById(R.id.weektvstoryteller);
         storyweektv = weekq.findViewById(R.id.namestoryfeat);
       weekimg = weekq.findViewById(R.id.picstoryfeat);

        //تعريف من class ستوري

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

        Story FA3 = new Story("طفولة المهيب صدام حسين … من هو والده الحقيقي ؟", 18, "جريمة", "", "فارس عاشور",
                "https://www.youtube.com/watch?v=dMKZ5pKirB0", R.drawable.channels4_profile);

        Story FA4 = new Story("القضية التي لن تموت في العراق", 16, "جريمة-حرب-حزينة", "", "فارس عاشور",
                "https://www.youtube.com/watch?v=U5dRNBQZeQA", R.drawable.channels4_profile);

        Story FA5 = new Story("متسولون أثرياء اغناهم إمرأة عربية", 15, "سرقة-غرائب", "", "فارس عاشور",
                "https://www.youtube.com/watch?v=XTSdt5MCZFk", R.drawable.channels4_profile);


        Story AALH = new Story("986 - قصة كلوديا البرازيلية ", 140, "جريمة-دراما-حب", "", "ابو طلال الحمراني",
                "https://www.youtube.com/watch?v=j0gxFXjQgmY", R.drawable.uhr9phho_400x400__1_);

        Story AALH2 = new Story("507 - قصة   الأسيرالكويتي في العراق ", 52, "مؤثرة-دراما-حرب", "", "ابو طلال الحمراني",
                "https://www.youtube.com/watch?v=bPhTLfQWZaM", R.drawable.uhr9phho_400x400__1_);

        Story AALH3 = new Story("525 - قصه 150 ألف دولار!", 60, "جريمة-عبرة", "", "ابو طلال الحمراني",
                "https://www.youtube.com/watch?v=C9-BHUyBNgo", R.drawable.uhr9phho_400x400__1_);

        Story AALH4 = new Story("260 - قصة جهيمان واقتحام الحرم المكي الشريف", 39, "جريمة -أكشن", "", "ابو طلال الحمراني",
                "https://www.youtube.com/watch?v=S2-Ndiek-HE", R.drawable.uhr9phho_400x400__1_);


// نسوي database بسيط للقصص
        RandomListDatabase.add(AMD2);
        RandomListDatabase.add(AMD3);
        RandomListDatabase.add(AMD4);
        RandomListDatabase.add(AMD5);
        RandomListDatabase.add(FA1);
        RandomListDatabase.add(FA2);
        RandomListDatabase.add(FA3);
        RandomListDatabase.add(FA4);
        RandomListDatabase.add(FA5);
        RandomListDatabase.add(AALH2);
        RandomListDatabase.add(AALH3);
        RandomListDatabase.add(AALH4);
        RandomListDatabase.add(AMD1);
        RandomListDatabase.add(AALH);
        // Featured

        Featured.add(AALH);
        Featured.add(AMD2);
        Featured.add(AALH4);
//scuffed navi bar
        CardView btm = findViewById(R.id.Btm);

        ImageView IV1 = btm.findViewById(R.id.mystory2);
        ImageView IV3 = btm.findViewById(R.id.Personal);
        ImageView IV2 = btm.findViewById(R.id.Chosen);


        IV1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainChosen2.this, AddNewUser.class);
                startActivity(intent);
            }
        });

        IV2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainChosen2.this, MainActivity.class);
                startActivity(intent);
            }
        });
        IV3.setOnClickListener(new View.OnClickListener() {
    @Override
   public void onClick(View view) {
  Toast toast = Toast.makeText(getApplicationContext(), "You're already here :)", Toast.LENGTH_SHORT);
    toast.show();
    }
   });

        // story of the session
        Random int2 = new Random();

        two = int2.nextInt(10);

        NameTv2.setText(RandomListDatabase.get(two).getStoryName());
        tellerTv2.setText(RandomListDatabase.get(two).getStoryTeller());
        Dayimg.setImageResource(RandomListDatabase.get(two).getStoryTellerIMG());


        Intent intent = new Intent(Intent.ACTION_VIEW);
        sessioncard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String link2 = RandomListDatabase.get(two).getStoryLink();
                intent.setData(Uri.parse(link2));
                startActivity(intent);
            }
        });

        //bottombar

       CardView bottom = findViewById(R.id.bottomBar);
        bottom.setOnClickListener(new View.OnClickListener() {
        @Override
          public void onClick(View view) {
              Intent intentBottom = new Intent(MainChosen2.this, StoryCategoryChoosen.class);

                startActivity(intentBottom);
            }
       });
// UP card button intents

        CTGC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent TGchoosen = new Intent(MainChosen2.this, CTGC.class);
                TGchoosen.putExtra("AMD1", AMD1);
                TGchoosen.putExtra("AMD2", AMD2);
                TGchoosen.putExtra("AMD3", AMD3);
                TGchoosen.putExtra("AMD4", AMD4);
                TGchoosen.putExtra("AMD5", AMD5);
                startActivity(TGchoosen);
            }
        });
        CFAC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent FAchoosen = new Intent(MainChosen2.this, CFAC.class);
                FAchoosen.putExtra("FA1", FA1);
                FAchoosen.putExtra("FA2", FA2);
                FAchoosen.putExtra("FA3", FA3);
                FAchoosen.putExtra("FA4", FA4);
                FAchoosen.putExtra("FA5", FA5);
                startActivity(FAchoosen);
            }
        });
        CAALHC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent AALHchoosen = new Intent(MainChosen2.this, CAALHC.class);
                AALHchoosen.putExtra("AALH", AALH);
                AALHchoosen.putExtra("AALH2", AALH2);
                AALHchoosen.putExtra("AALH3", AALH3);
                AALHchoosen.putExtra("AALH4", AALH4);

                startActivity(AALHchoosen);
            }
        });








// random button settings

        Randombutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random int1 = new Random();

                one = int1.nextInt(10);


                if (one != two && one != three && one != five) {

                    RandomNameTV.setText(RandomListDatabase.get(one).getStoryName());
                    tellerTV.setText(RandomListDatabase.get(one).getStoryTeller());
                    RandomIMG.setImageResource(RandomListDatabase.get(one).getStoryTellerIMG());

                } else {

                    one = int1.nextInt(10);


                }
                int finalOne = one;
                Randomresult.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(Intent.ACTION_VIEW);

                        String link = RandomListDatabase.get(finalOne).getStoryLink();
                        intent.setData(Uri.parse(link));
                        startActivity(intent);

                    }


                });


                ;
            }
        });

        Handler handler = new Handler(Looper.getMainLooper());

        storyweektv.setText(Featured.get(0).getStoryName());
        tellerweektv.setText(Featured.get(0).getStoryTeller());
        weekimg.setImageResource(Featured.get(0).getStoryTellerIMG());

    Runnable runnable = new Runnable() {



        @Override

        public void run() {


          five ++;

if (five == 3) {


    five = 0 ;
    storyweektv.setText(Featured.get(five).getStoryName());
    tellerweektv.setText(Featured.get(five).getStoryTeller());
    weekimg.setImageResource(Featured.get(five).getStoryTellerIMG());

} else {


    storyweektv.setText(Featured.get(five).getStoryName());
    tellerweektv.setText(Featured.get(five).getStoryTeller());
    weekimg.setImageResource(Featured.get(five).getStoryTellerIMG());

weekq.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW);

        String link = Featured.get(five).getStoryLink();
        intent.setData(Uri.parse(link));
        startActivity(intent);
    }
});

}
            handler.postDelayed(this, 5000);
            }
        };
  runnable.run();


    }
    }







