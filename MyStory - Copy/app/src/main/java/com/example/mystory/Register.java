package com.example.mystory;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class Register extends AppCompatActivity implements View.OnClickListener {
    private FirebaseAuth mAuth;
    private EditText NameReg, PassReg, EmailReg;
    ProgressBar progressBar;
    Button Regbtn;
    TextView banner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().hide();



        mAuth = FirebaseAuth.getInstance();
        NameReg = (EditText) findViewById(R.id.NameReg);
        EmailReg = (EditText) findViewById(R.id.EmailReg);
        PassReg = (EditText) findViewById(R.id.PassReg);

        banner = (TextView) findViewById(R.id.banner);
        banner.setOnClickListener(this);

       Regbtn = (Button) findViewById(R.id.Register);
        Regbtn.setOnClickListener(this);

       progressBar = (ProgressBar) findViewById(R.id.ProBar3);


    }



    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.banner:
                startActivity(new Intent(this, Login.class));
                break;
            case R.id.Register:
                registerUser();
                break;

        }
    }



    private void registerUser () {
        String email = EmailReg.getText().toString().trim();;
        String pass = PassReg.getText().toString().trim();
        String Name = NameReg.getText().toString().trim();



        if (Name.isEmpty()) {
            NameReg.setError("Name is required ");
            NameReg.requestFocus();
            return;
        }




        if (email.isEmpty()) {
            EmailReg.setError("Email is required ");
            EmailReg.requestFocus();
            return;
        }



            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {

                EmailReg.setError("Please provide valid email");
                EmailReg.requestFocus();
                return;


        }




        if (pass.isEmpty()) {
                PassReg.setError("Password is required ");
                PassReg.requestFocus();
                return;


            }



        if (pass.length() < 6 ) {

            PassReg.setError("Password is too short! ");
            PassReg.requestFocus();
            return;

        }





        progressBar.setVisibility(View.VISIBLE);
        mAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful()) {
                    User user = new User(Name, email, pass);
                    FirebaseDatabase.getInstance().getReference("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(user)
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {


                                        Toast.makeText(Register.this, "User has been registered", Toast.LENGTH_LONG).show();
                                        progressBar.setVisibility(View.VISIBLE);

                                    }else{
                                        Toast.makeText(Register.this, "Failed to register", Toast.LENGTH_LONG).show();
                                        progressBar.setVisibility(View.GONE);
                                    }
                                }
                            });


                }


            }
        });


    }

}