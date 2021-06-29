package com.example.movieticketbookingassignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SeatBookActivity extends AppCompatActivity {
    RecyclerView recyclerview;
    Button saveBttn;
    ImageView imageView;
    Spinner spinner;
    ArrayAdapter<String> arrayAdapter_movie;
    Dialog dialog;
    TextView text_view;
    ArrayList<Boolean> imagelist;
    ArrayList<String> movieList;
    String moviename;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seat_book);
        recyclerview = findViewById(R.id.recyclerview);
        spinner = findViewById(R.id.spinner);
        saveBttn = findViewById(R.id.saveBttn);
        text_view = findViewById(R.id.text_view);
        dialog = new Dialog(this);


        imagelist = new ArrayList<>();
        int counter = 0;
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
        movieList.add(0, "Select Movie Name");
        movieList.add("Kabhi Khushi Kabhi Gham");
        movieList.add("Bahubali 2");
        movieList.add("Dilwale Dulhania le Jayenge");
        movieList.add("Jab We Met");
        movieList.add("3 Idiots");
        arrayAdapter_movie = new ArrayAdapter<>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, movieList);
        arrayAdapter_movie.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter_movie);


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String selectedItemText = (String) adapterView.getItemAtPosition(i);
                text_view.setText("Selected : " + selectedItemText);
                if (adapterView.getItemAtPosition(i).equals("Select Movie Name")) {

                } else {
                    moviename = adapterView.getItemAtPosition(i).toString();
                    Toast.makeText(getApplicationContext(), moviename + " selected successfully", Toast.LENGTH_SHORT).show();

                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(getApplicationContext(), "No selection", Toast.LENGTH_LONG).show();
            }
        });



      /*  if (getIntent() != null) {
            int image = getIntent().getExtras().getInt("my image");
            imageView.setImageResource(image);
        }*/


        saveBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                /*String state = spinner.getSelectedItem().toString();

                finish();
*/


                openCustomDialog();
            }
        });

    }


    private void openCustomDialog() {


        dialog.setContentView(R.layout.custom_pop_up);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        String state = spinner.getSelectedItem().toString();

        TextView mNameText = dialog.findViewById(R.id.mNameText);
        mNameText.setText(state);
        String time = getIntent().getStringExtra("timeSlot");
        TextView timeSlotText = dialog.findViewById(R.id.timeSlotText);
        timeSlotText.setText(time);
        Button savBttn = dialog.findViewById(R.id.saveBttn);

        savBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Show Book Successfully", Toast.LENGTH_SHORT).show();
                finish();
            }
        });


       /* int counter = 0;
        for (int i = 0; i < imagelist.size(); i++) {
            if (imagelist.get(i)) {
                counter++;
            }
        }*/

        //TextView sBookText = dialog.findViewById(R.id.sBookText);
        //sBookText.setText(counter);

        dialog.show();
    }


}