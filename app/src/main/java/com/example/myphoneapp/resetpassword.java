package com.example.myphoneapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class resetpassword extends AppCompatActivity {
    private EditText emailidrs;
    private Button reset1;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //Will Hide the Title
        getSupportActionBar().hide(); //Hide the Title Bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN); //Enable Full Screen

        setContentView(R.layout.activity_resetpassword);
        emailidrs=findViewById(R.id.emailrs);
        reset1=findViewById(R.id.reset);

        auth=FirebaseAuth.getInstance();
        reset1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetPassword();
            }
        });
    }

    private void resetPassword() {
        String email=emailidrs.getText().toString().trim();
        if(email.isEmpty())
        {
            emailidrs.setError("Email is required");
            emailidrs.requestFocus();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {
            emailidrs.setError("Please provide valid email ");
            emailidrs.requestFocus();
            return;
        }
        auth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){
                    Toast.makeText(resetpassword.this, "Check your email to reset your password", Toast.LENGTH_LONG).show();

                }
                else{
                    Toast.makeText(resetpassword.this, "Try again something wrong happened", Toast.LENGTH_LONG).show();

                }
            }
        });
    }
}