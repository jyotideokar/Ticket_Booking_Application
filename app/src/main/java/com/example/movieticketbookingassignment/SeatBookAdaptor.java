package com.example.movieticketbookingassignment;

import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class SeatBookAdaptor extends RecyclerView.Adapter<SeatBookAdaptor.ViewHolder> {
    private ArrayList<Boolean> integerList;

    public SeatBookAdaptor(ArrayList<Boolean> integerList) {
        this.integerList = integerList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.seat_item_layout, parent, false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
       if (integerList.get(position)){
           holder.chairImage.setBackgroundColor(Color.BLUE);
       }
       else {
           holder.chairImage.setBackgroundColor(Color.TRANSPARENT );
       }
        holder.chairImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (integerList.get(position)){
                  integerList.set(position,false);
                }
                else {
                    integerList.set(position,true);
                }
                notifyDataSetChanged();
            }
        });
    }
    @Override
    public int getItemCount() {
        return integerList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView chairImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            chairImage = itemView.findViewById(R.id.chairImage);
        }
    }
}
