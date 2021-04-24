package com.example.myphoneapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.util.Patterns;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class login extends AppCompatActivity implements View.OnClickListener {
    private TextView banner,forgotpassword,register1;
    private ImageView imageView1;
    private Button signin;
    private EditText email1,password1;

    FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //Will Hide the Title
        getSupportActionBar().hide(); //Hide the Title Bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN); //Enable Full Screen
        setContentView(R.layout.activity_login);

        // Hooks
        signin = findViewById(R.id.signin);
        signin.setOnClickListener(this);
        imageView1 = findViewById(R.id.imageView);
        banner = findViewById(R.id.banner);

        email1 = findViewById(R.id.email);
        password1 = findViewById(R.id.password);
        forgotpassword = findViewById(R.id.forpass);
        forgotpassword.setOnClickListener(this);
        register1=findViewById(R.id.register);
        register1.setOnClickListener(this);
        mAuth=FirebaseAuth.getInstance();



    }


    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.register) {
            startActivity(new Intent(this,sign_up.class));
        } else if (id == R.id.signin) {
            userLogin();
        }
        else if (id == R.id.forpass) {
            startActivity(new Intent(this,resetpassword.class));
        }

    }

    private void userLogin() {
        String email=email1.getText().toString().trim();
        String password=password1.getText().toString().trim();
        if(email.isEmpty())
        {
            email1.setError("Email is required");
            email1.requestFocus();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {
            email1.setError("Please provide valid email ");
            email1.requestFocus();
            return;
        }
        if(password.isEmpty())
        {
            password1.setError("UserId is required");
            password1.requestFocus();
            return;
        }
        if(password.length()<5){
            password1.setError("Min Password length should be 5");
            password1.requestFocus();
            return;
        }
        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    FirebaseUser user=FirebaseAuth.getInstance().getCurrentUser();
                    if(user.isEmailVerified()){
                        startActivity(new Intent(login.this,nav_main.class));

                    }
                    else{
                        user.sendEmailVerification();
                        Toast.makeText(login.this, "Check your email to verify your account", Toast.LENGTH_LONG).show();

                    }


                }
                else{
                    Toast.makeText(login.this, "Failed to login! Try again", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}