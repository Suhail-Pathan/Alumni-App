package com.example.myphoneapp;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;


public class nav_main extends AppCompatActivity {
    private FirebaseUser user;
    private DatabaseReference reference;
    private String userID;
    NavigationView nav;
    ActionBarDrawerToggle toggle;
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //Will Hide the Title
        getSupportActionBar().hide(); //Hide the Title Bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN); //Enable Full Screen


        setContentView(R.layout.activity_nav_main);

        toolbar = findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        nav = findViewById(R.id.navmenu);
        drawerLayout=findViewById(R.id.drawer);
        toggle=new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.openNavDrawer, R.string.closeNavDrawer);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId())
                {
                    case R.id.menu_home :
                        Intent intenth1= new Intent(nav_main.this,home_page.class);
                        startActivity(intenth1);
                        Toast.makeText(getApplicationContext(),"Home panel is open",Toast.LENGTH_LONG).show();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.menu_photos :
                        Intent intent= new Intent(nav_main.this,Extended_Gallery.class);
                        startActivity(intent);
                        //Toast.makeText(getApplicationContext(),"Photos panel is open",Toast.LENGTH_LONG).show();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.menu_videos :
                        Intent intentV= new Intent(nav_main.this,VideoPlayer.class);
                        startActivity(intentV);
                        Toast.makeText(getApplicationContext(),"Videos panel is open",Toast.LENGTH_LONG).show();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.menu_events :
                        Toast.makeText(getApplicationContext(),"Events panel is open",Toast.LENGTH_LONG).show();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.menu_news :
                        Toast.makeText(getApplicationContext(),"News is open",Toast.LENGTH_LONG).show();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.menu_sociallinks:
                        Intent intenthS= new Intent(nav_main.this,  FirebaseRecycle.class);
                        startActivity(intenthS);
                        Toast.makeText(getApplicationContext(),"Social-link is open",Toast.LENGTH_LONG).show();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.menu_feed :
                        Intent intent1= new Intent(nav_main.this,menu_feedback.class);
                        startActivity(intent1);
                        //Toast.makeText(getApplicationContext(),"FAQ panel is open",Toast.LENGTH_LONG).show();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.menu_faq :

                        Toast.makeText(getApplicationContext(),"FAQ panel is open",Toast.LENGTH_LONG).show();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.menu_logout :
                        Intent intent10= new Intent(nav_main.this,login.class);
                        FirebaseAuth.getInstance().signOut();
                        startActivity(intent10);
                        //Toast.makeText(getApplicationContext(),"Logout panel is open",Toast.LENGTH_LONG).show();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                }
                return true;
            }
        });
        user = FirebaseAuth.getInstance().getCurrentUser();
        reference= FirebaseDatabase.getInstance().getReference("Users");
        userID=user.getUid();
        NavigationView navigationView = (NavigationView) findViewById(R.id.navmenu);
        View header = navigationView.getHeaderView(0);
        TextView text1 = (TextView) header.findViewById(R.id.header_name);
        TextView text2 = (TextView) header.findViewById(R.id.header_email);

        reference.child(userID).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                user userProfile=snapshot.getValue(user.class);
                if(userProfile != null)
                {
                    String name=userProfile.name;
                    String email=userProfile.email;
                    String prn=userProfile.prn;
                    text1.setText(name);
                    text2.setText(email);

                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(nav_main.this,"Something wrong happened",Toast.LENGTH_LONG).show();

            }
        });
    }




}