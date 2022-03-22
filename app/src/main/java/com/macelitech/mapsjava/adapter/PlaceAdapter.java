package com.macelitech.mapsjava.adapter;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.Placeholder;
import androidx.recyclerview.widget.RecyclerView;

import com.macelitech.mapsjava.databinding.RecylerRowBinding;
import com.macelitech.mapsjava.model.Place;
import com.macelitech.mapsjava.view.MapsActivity;

import java.util.List;

public class PlaceAdapter extends RecyclerView.Adapter<PlaceAdapter.PlaceHolder> {

    List<Place> placeList;
    
    RecylerRowBinding recylerRowBinding;

    public PlaceAdapter(List<Place> placeList){
        this.placeList = placeList;
    }

    @NonNull
    @Override
    public PlaceHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        recylerRowBinding = RecylerRowBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new PlaceHolder(recylerRowBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull PlaceAdapter.PlaceHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.recylerRowBinding.recylerViewTextView.setText(placeList.get(position).name);

        holder.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.itemView.getContext(), MapsActivity.class);
                intent.putExtra("info","old");
                intent.putExtra("place",placeList.get(position));
                holder.itemView.getContext().startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return placeList.size();
    }

    public class PlaceHolder extends RecyclerView.ViewHolder{
        RecylerRowBinding recylerRowBinding;
        public PlaceHolder(RecylerRowBinding recylerRowBinding) {
            super(recylerRowBinding.getRoot());
            this.recylerRowBinding = recylerRowBinding;
        }
    }

}
