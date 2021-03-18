package com.example.myphoneapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.regex.Pattern;

public class sign_up extends AppCompatActivity implements View.OnClickListener {
     private TextView banner;

     private Button register1;
     private ImageView imageView1;
     private EditText UserName1,PRN_Number1,email1,password1;

     FirebaseAuth mAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //Will Hide the Title
        getSupportActionBar().hide(); //Hide the Title Bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN); //Enable Full Screen
        setContentView(R.layout.register);
        mAuth = FirebaseAuth.getInstance();

        banner=findViewById(R.id.banner);
        banner.setOnClickListener(this);

        // Hooks
        imageView1 = findViewById(R.id.imageView);


        UserName1= findViewById(R.id.username);
        PRN_Number1=findViewById(R.id.PRN_Number);
        email1=findViewById(R.id.email);

        password1=findViewById(R.id.password);


        register1=findViewById(R.id.register);
        register1.setOnClickListener(this);




    }
    @Override
    public void onClick(View v)
    {
        int id = v.getId();
        if (id == R.id.banner) {
            startActivity(new Intent(this,login.class));
        } else if (id == R.id.register) {
            register();
        }
    }



     void register() {
        String email=email1.getText().toString().trim();
        String username=UserName1.getText().toString().trim();
        String prnNumber=PRN_Number1.getText().toString().trim();

        String password=password1.getText().toString().trim();

        if(username.isEmpty())
        {
         UserName1.setError("UserId is required");
         UserName1.requestFocus();
         return;
        }
        if(prnNumber.isEmpty())
        {
            PRN_Number1.setError("PRNNumber is required");
            PRN_Number1.requestFocus();
            return;
        }
         if(prnNumber.length()<15){
             password1.setError("Min length should be 15");
             password1.requestFocus();
             return;
         }
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
        mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {
                    user user1=new user(username,prnNumber,email);
                    FirebaseDatabase.getInstance().getReference("Users")
                            .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                            .setValue(user1).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task)
                        {
                            if(task.isSuccessful()){
                                Toast.makeText(sign_up.this,"User has been register sucessfully!",Toast.LENGTH_LONG).show();
                            }
                            else {
                                Toast.makeText(sign_up.this, "Failed to register! Try again", Toast.LENGTH_LONG).show();
                            }
                        }
                    });
                }
                else{
                    Toast.makeText(sign_up.this, "Failed to register! Try again", Toast.LENGTH_LONG).show();


                }

            }
        });


    }
}