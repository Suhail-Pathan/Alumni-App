package com.example.myphoneapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class userprofile extends AppCompatActivity {
    private FirebaseUser user;
    private DatabaseReference reference;
    private String userID;
    private Button logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //Will Hide the Title
        getSupportActionBar().hide(); //Hide the Title Bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN); //Enable Full Screen
        setContentView(R.layout.activity_userprofile);

        logout=findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(userprofile.this,login.class));
            }
        });

      user =FirebaseAuth.getInstance().getCurrentUser();
      reference= FirebaseDatabase.getInstance().getReference("Users");
      userID=user.getUid();
      final TextView email1=findViewById(R.id.email_view);
        final TextView username1=findViewById(R.id.username_view);
        final TextView prn1=findViewById(R.id.prnnumber_view);
        reference.child(userID).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                user userProfile=snapshot.getValue(user.class);
                if(userProfile != null)
                {
                    String name=userProfile.name;
                    String email=userProfile.email;
                    String prn=userProfile.prn;
                    username1.setText(name);
                    email1.setText(email);
                    prn1.setText(prn);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(userprofile.this,"Something wrong happened",Toast.LENGTH_LONG).show();
            }
        });

    }
}