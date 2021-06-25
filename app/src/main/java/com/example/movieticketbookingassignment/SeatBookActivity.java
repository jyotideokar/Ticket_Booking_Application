package com.example.movieticketbookingassignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SeatBookActivity extends AppCompatActivity {
    RecyclerView recyclerview;
    Button saveBttn;
    ImageView imageView;
    Spinner spinner;
    ArrayAdapter<String> arrayAdapter_movie;

    ArrayList<String> movieList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seat_book);
        recyclerview = findViewById(R.id.recyclerview);
        spinner = findViewById(R.id.movieList);
        saveBttn = findViewById(R.id.saveBttn);

        ArrayList<Boolean> imagelist = new ArrayList<>();
        imagelist.add(false);
        for (int i = 0; i <= 45; i++) {
            imagelist.add(false);
        }

      /*  public class MyClass {
            public static void main(String args[]) {

                int counter=0;
                ArrayList<Boolean> imageList = new ArrayList();
                for(int i=0;i<imageList.size();i++){
                    if(imageList.get(i)){
                        counter++;
                    }
                }
                System.out.println("Total Selected Seats " + counter);
            }
        }*/


        SeatBookAdaptor seatBookAdaptor = new SeatBookAdaptor(imagelist);
        recyclerview.setAdapter(seatBookAdaptor);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 5, GridLayoutManager.VERTICAL, false);
        recyclerview.setLayoutManager(gridLayoutManager);


        movieList = new ArrayList<>();
        movieList.add("Select Movie Name");
        movieList.add("Kabhi Khushi Kabhi Gham");
        movieList.add("Bahubali 2");
        movieList.add("Dilwale Dulhania le Jayenge");
        movieList.add("Jab We Met");
        movieList.add("3 Idiots");
        arrayAdapter_movie = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, movieList);
        spinner.setAdapter(arrayAdapter_movie);




      /*  if (getIntent() != null) {
            int image = getIntent().getExtras().getInt("my image");
            imageView.setImageResource(image);
        }*/


        saveBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String state = spinner.getSelectedItem().toString();

                Toast.makeText(getApplicationContext(),state +" Show book successfully",Toast.LENGTH_SHORT).show();
                finish();

            }
        });


    }
}