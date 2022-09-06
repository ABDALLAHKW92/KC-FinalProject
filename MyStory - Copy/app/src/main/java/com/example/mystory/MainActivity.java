package com.example.mystory;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
private FirebaseUser user;
private DatabaseReference reference;
private String userID;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        getSupportActionBar().hide();
//scuffed navi bar
        CardView btm = findViewById(R.id.Btm);

        ImageView IV1 = btm.findViewById(R.id.mystory2);
        ImageView IV3 = btm.findViewById(R.id.Personal);
        ImageView IV2 = btm.findViewById(R.id.Chosen);


        IV1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddNewUser.class);
                startActivity(intent);
            }
        });

        IV2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = Toast.makeText(getApplicationContext(), "You're already here :)", Toast.LENGTH_SHORT);
                toast.show();
            }
        });
        IV3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainChosen2.class);
                startActivity(intent);
            }
        });



        user = FirebaseAuth.getInstance().getCurrentUser();
        reference = FirebaseDatabase.getInstance().getReference("Users");
        userID = user.getUid();




        final TextView Email = (TextView) findViewById(R.id.UserEmail);
        final TextView NameTV = (TextView) findViewById(R.id.UserName);
        reference.child(userID).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                User UserProfile = snapshot.getValue(User.class);
                if (user != null){
                  String NameString = UserProfile.Name;
                    String EmailString = UserProfile.Email;
                    Email.setText(EmailString);
                    NameTV.setText(NameString);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
Toast.makeText(MainActivity.this, "Could not load user details", Toast.LENGTH_LONG).show();
            }
        });
    }
}