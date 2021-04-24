package com.example.myphoneapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class menu_feedback extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_feedback);
        EditText edit1=(EditText)findViewById(R.id.edit1);
        EditText edit2=(EditText)findViewById(R.id.edit2);
        Button btn=(Button)findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Intent.ACTION_SEND);
                i.setType("message/html");
                i.putExtra(android.content.Intent.EXTRA_EMAIL,new String[] { "suhailkhan144@gmail.com" });
                i.putExtra(Intent.EXTRA_SUBJECT,"Feedback Form App");
                i.putExtra(Intent.EXTRA_TEXT, "Nmae:"+edit1.getText()+"\n Message:"+edit2.getText());
                try {
                    startActivity(Intent.createChooser(i,"Please select Email"));
                }
                catch (android.content.ActivityNotFoundException ex)
                {
                    Toast.makeText(menu_feedback.this, "There are no Email Clients", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}













