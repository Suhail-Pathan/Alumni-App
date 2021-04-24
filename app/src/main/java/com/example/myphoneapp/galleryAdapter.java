package com.example.myphoneapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class  galleryAdapter extends RecyclerView.Adapter<galleryAdapter.GalleryViewAdapter> implements View.OnClickListener{

   private Context context;
    public List<Integer> galleryImages;

    public galleryAdapter(Context context, List<Integer> galleryImages) {
        this.context = context;
        this.galleryImages = galleryImages;
    }

    @NonNull
    @Override
    public GalleryViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.gallery_image,parent,false);
        return new GalleryViewAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GalleryViewAdapter holder,  final int position) {


        Glide.with(context).load(galleryImages.get(position)).into(holder.imageIcon);
        holder.imageIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,fullimageView.class);
                intent.putExtra("image",galleryImages.get(position));
                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return galleryImages.size();
    }

    @Override
    public void onClick(View v) {

    }

    public class GalleryViewAdapter extends RecyclerView.ViewHolder {
   ImageView imageIcon;
        public GalleryViewAdapter(@NonNull View itemView) {
            super(itemView);
            imageIcon=itemView.findViewById(R.id.gallery_image1);

        }
    }
}
