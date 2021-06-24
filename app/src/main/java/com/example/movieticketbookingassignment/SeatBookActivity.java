package com.example.movieticketbookingassignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class SeatBookActivity extends AppCompatActivity {
    RecyclerView recyclerview;
    Button saveBttn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seat_book);
        recyclerview = findViewById(R.id.recyclerview);
        saveBttn = findViewById(R.id.saveBttn);

        ArrayList<Boolean> imagelist = new ArrayList<>();
        imagelist.add(false);
        for (int i = 0; i<=56;i++){
            imagelist.add(false);
        }
        
        SeatBookAdaptor seatBookAdaptor = new SeatBookAdaptor(imagelist);
        recyclerview.setAdapter(seatBookAdaptor);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 5, GridLayoutManager.VERTICAL, false);
        recyclerview.setLayoutManager(gridLayoutManager);


        saveBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });



    }
}