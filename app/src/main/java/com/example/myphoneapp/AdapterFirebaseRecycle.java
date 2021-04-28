package com.example.myphoneapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myphoneapp.FirebaseRecycle;
import com.example.myphoneapp.user;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class AdapterFirebaseRecycle extends FirebaseRecyclerAdapter<user,AdapterFirebaseRecycle.myviewholder>
{

    public AdapterFirebaseRecycle(@NonNull FirebaseRecyclerOptions<user> options) {
        super(options);
    }




    @Override
    protected void onBindViewHolder(@NonNull myviewholder holder, int position, @NonNull user user)
    {
        holder.name.setText(user.getName());
        holder.prn.setText(user.getPrn());
        holder.email.setText(user.getEmail());

    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow,parent,false);
        return new myviewholder(view);
    }



    class myviewholder extends RecyclerView.ViewHolder
    {
        CircleImageView img;
        TextView name,prn,email;
        public myviewholder(@NonNull View itemView)
        {
            super(itemView);
            img=(CircleImageView)itemView.findViewById(R.id.img1);
            name=(TextView)itemView.findViewById(R.id.nametext);
            prn=(TextView)itemView.findViewById(R.id.prntext);
            email=(TextView)itemView.findViewById(R.id.emailtext);
        }
    }
}
