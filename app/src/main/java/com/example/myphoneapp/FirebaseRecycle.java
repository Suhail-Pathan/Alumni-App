package com.example.myphoneapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.SearchView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class FirebaseRecycle extends AppCompatActivity {
    RecyclerView firebase_recycle;
    AdapterFirebaseRecycle adapterFirebaseRecycle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase_recycle);



        firebase_recycle=(RecyclerView)findViewById(R.id.firebase_recycle);
        firebase_recycle.setLayoutManager(new LinearLayoutManager(this));
        FirebaseRecyclerOptions<user> options =
                new FirebaseRecyclerOptions.Builder<user>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Users"), user.class)
                        .build();
        adapterFirebaseRecycle=new AdapterFirebaseRecycle(options);
        firebase_recycle.setAdapter(adapterFirebaseRecycle);

    }
    @Override
    protected void onStart() {
        super.onStart();
        adapterFirebaseRecycle.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapterFirebaseRecycle.stopListening();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.recycle_search,menu);

        MenuItem item=menu.findItem(R.id.search);

        android.widget.SearchView searchView=(android.widget.SearchView)item.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                processsearch(s);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                processsearch(s);
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }

    private void processsearch(String s)
    {


        FirebaseRecyclerOptions<user> options =
                new FirebaseRecyclerOptions.Builder<user>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Users").orderByChild("name").startAt(s).endAt(s+"\uf8ff"), user.class)
                        .build();

        adapterFirebaseRecycle=new AdapterFirebaseRecycle(options);
        adapterFirebaseRecycle.startListening();
        firebase_recycle.setAdapter(adapterFirebaseRecycle);

    }
}