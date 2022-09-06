package com.example.mystory;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddNewUser extends AppCompatActivity {
EditText NAme, link, teller, rating;
Button  insert, view;
DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_user);
getSupportActionBar().hide();

        NAme = findViewById(R.id.Nameet);
        link = findViewById(R.id.Linket);
        teller = findViewById(R.id.Telleret);
        rating = findViewById(R.id.Ratinget);



        insert = findViewById(R.id.Save);
       view = findViewById(R.id.viewlist);

        DB = new DBHelper(this);


        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AddNewUser.this, userdata.class));
            }
        });
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String NameTXT = NAme.getText().toString();
                String tellerTXT= teller.getText().toString();
                String linkTXT = link.getText().toString();
                int rateint = Integer.parseInt(rating.getText().toString());

                String RatingTXT = String.valueOf(rateint);

                    Boolean checkinsertdata = DB.insertuserdata(NameTXT, tellerTXT, linkTXT,RatingTXT);
if (checkinsertdata == true){

    Toast.makeText(AddNewUser.this, "Data has been entered successfully!", Toast.LENGTH_SHORT).show();


}else{

    Toast.makeText(AddNewUser.this, "Please check your data", Toast.LENGTH_SHORT).show();

}
            }
        });
    }
}