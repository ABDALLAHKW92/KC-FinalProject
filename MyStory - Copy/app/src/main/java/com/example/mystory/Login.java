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

public class Login extends AppCompatActivity implements View.OnClickListener {
 private TextView register;
 private EditText EmailLog, PassLog;
 private Button Login;
 private ProgressBar ProBar;
 private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();



        EmailLog = (EditText) findViewById(R.id.EmailLog);
      PassLog = (EditText) findViewById(R.id.PassLog);

      Login = (Button) findViewById(R.id.Login);

     ProBar = (ProgressBar) findViewById(R.id.Barood);



        register = (TextView) findViewById(R.id.Reg);
        register.setOnClickListener(this);
Login.setOnClickListener(this);
        mAuth = FirebaseAuth.getInstance();
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.Reg:
                startActivity(new Intent(this, Register.class));
                break;
            case R.id.Login:
                userLogin();

        }
    }

    private void userLogin() {


        String email = EmailLog.getText().toString().trim();
        String pass = PassLog.getText().toString().trim();

        if (email.isEmpty()) {
            EmailLog.setError("Email is required ");
            EmailLog.requestFocus();
            return;
        }


        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {

            EmailLog.setError("Please provide valid email");
            EmailLog.requestFocus();
            return;


        }
        if (pass.isEmpty()) {
            PassLog.setError("Password is required ");
            PassLog.requestFocus();
            return;
        }
        if (pass.length() < 6 ) {

            PassLog.setError("Password is too short! ");
            PassLog.requestFocus();
            return;

        }
        ProBar.setVisibility(View.VISIBLE);
        mAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                   //redirect user profile
                 startActivity(new Intent(Login.this, MainActivity.class));

                }else {


                    Toast.makeText(Login.this, "Failed to login, check your details!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}