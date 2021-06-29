package com.example.movieticketbookingassignment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;

public class Content_List_Activity extends AppCompatActivity {

    Spinner citySpinner, theaterSpinner, timeSpinner;
    ArrayList<String> arrayList_city;
    ArrayAdapter<String> arrayAdapter_city;
    ArrayList<String> arrayList_theater;
    ArrayAdapter<String> arrayAdapter_theater;
    ArrayList<String> timeArrayList;
    ArrayAdapter<String> arrayAdapter_time;
    CircleIndicator circleIndicator;
    ViewPager viewPager;
    Button bookBttn;
    String selectedCity, selectedTheater, selectedTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content__list_);
        timeSpinner = findViewById(R.id.timeSpinner);
        theaterSpinner = findViewById(R.id.theaterSpinner);
        citySpinner = findViewById(R.id.citySpinner);
        bookBttn = findViewById(R.id.bookBttn);
        circleIndicator = findViewById(R.id.circleIndicator);
        viewPager = findViewById(R.id.viewPager);
        List<Integer> imageList = new ArrayList<>();
        imageList.add(R.drawable.kkkg);
        imageList.add(R.drawable.bahubali);
        imageList.add(R.drawable.ddlj);
        imageList.add(R.drawable.jab_we_met);
        imageList.add(R.drawable.threeidiot);
        ViewPagerAdaptor viewPagerAdaptor = new ViewPagerAdaptor(imageList, this);
        viewPager.setAdapter(viewPagerAdaptor);

        circleIndicator.setViewPager(viewPager);

        arrayList_city = new ArrayList<>();
        arrayList_city.add("Select City");
        arrayList_city.add("Loni");
        arrayList_city.add("Pune");
        arrayList_city.add("Mumbai");

        arrayAdapter_city = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayList_city);

        citySpinner.setAdapter(arrayAdapter_city);

        arrayList_theater = new ArrayList<>();


        citySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i > 0) {
                    selectedCity = arrayList_city.get(i);
                } else {
                    selectedCity = null;
                }
                arrayList_theater.clear();
                arrayList_theater.add("Select Theater");
                if (i == 1) {
                    arrayList_theater.add("Nathganga");
                    arrayList_theater.add("shantinath");
                    arrayList_theater.add("chitralay");
                }
                if (i == 2) {
                    arrayList_theater.add("Carnival");
                    arrayList_theater.add("Movie Multiplex");
                }
                if (i == 3) {
                    arrayList_theater.add("Maratha Mandir");
                }
                arrayAdapter_theater = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayList_theater);
                theaterSpinner.setAdapter(arrayAdapter_theater);

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        timeArrayList = new ArrayList<>();
        timeArrayList.add("Select Time");
        timeArrayList.add("12 P.M");
        timeArrayList.add("4 P.M");

        theaterSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i > 0) {
                    selectedTheater = arrayList_theater.get(i);
                } else {
                    selectedTheater = null;
                }

                timeArrayList.clear();
                arrayAdapter_time = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, timeArrayList);
                timeSpinner.setAdapter(arrayAdapter_time);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        timeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position > 0) {
                    selectedTime = timeArrayList.get(position);
                } else {
                    selectedTime = null;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        bookBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (selectedCity == null || selectedTheater == null || selectedTime == null) {
                    Toast.makeText(Content_List_Activity.this, "Plesae select all fields", Toast.LENGTH_SHORT).show();
                } else {
                    Intent bookIntent = new Intent(Content_List_Activity.this, SeatBookActivity.class);
                    bookIntent.putExtra("Time", selectedTime);
                    bookIntent.putExtra("City", selectedCity);
                    bookIntent.putExtra("Theater", selectedTheater);
                    startActivity(bookIntent);
                }

            }
        });


    }
}