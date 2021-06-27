package com.example.movieticketbookingassignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;

public class Content_List_Activity extends AppCompatActivity {

    Spinner citySpinner, theaterSpinner, timeSpinner;
    ArrayList<String> arrayList_city;
    ArrayAdapter<String> arrayAdapter_city;
    ArrayList<String> arrayList_loni, arrayList_shirdi, arrayList_pune, arrayList_mumbai;
    ArrayAdapter<String> arrayAdapter_theater;
    ArrayList<String> Nathganga, shantinath, chitralay, Carnival, Multiplex, Maratha;
    ArrayAdapter<String> arrayAdapter_time;
    CircleIndicator circleIndicator;
    ViewPager viewPager;
    Button bookBttn;

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
        ViewPagerAdaptor viewPagerAdaptor = new ViewPagerAdaptor(imageList,this);
        viewPager.setAdapter(viewPagerAdaptor);

        circleIndicator.setViewPager(viewPager);

        arrayList_city = new ArrayList<>();
        arrayList_city.add("Loni");
        arrayList_city.add("Pune");
        arrayList_city.add("Mumbai");

        arrayAdapter_city = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayList_city);

        citySpinner.setAdapter(arrayAdapter_city);

        arrayList_loni = new ArrayList<>();
        arrayList_loni.add("Nathganga");
        arrayList_loni.add("shantinath");
        arrayList_loni.add("chitralay");


        arrayList_pune = new ArrayList<>();
        arrayList_pune.add("Carnival");
        arrayList_pune.add("Movie Multiplex");

        arrayList_mumbai = new ArrayList<>();
        arrayList_mumbai.add("Maratha Mandir");
        citySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                if (i == 0) {
                    arrayAdapter_theater = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayList_loni);
                }
                if (i == 1) {
                    arrayAdapter_theater = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayList_pune);
                }
                if (i == 2) {
                    arrayAdapter_theater = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayList_mumbai);

                }
                theaterSpinner.setAdapter(arrayAdapter_theater);

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        Nathganga = new ArrayList<>();
        Nathganga.add("12 P.M");
        Nathganga.add("4 P.M");

        shantinath = new ArrayList<>();
        shantinath.add("12 P.M");
        shantinath.add("4.P.M");

        chitralay = new ArrayList<>();
        chitralay.add("12 P.M");
        chitralay.add("4.P.M");

        Carnival = new ArrayList<>();
        Carnival.add("12 P.M");
        Carnival.add("4.P.M");

        Multiplex = new ArrayList<>();
        Multiplex.add("12 P.M");
        Multiplex.add("4.P.M");

        Maratha = new ArrayList<>();
        Maratha.add("12 P.M");
        Maratha.add("4.P.M");

        theaterSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    arrayAdapter_time = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, Nathganga);
                }
                if (i == 1) {
                    arrayAdapter_time = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, shantinath);
                }
                if (i == 2) {
                    arrayAdapter_time = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, chitralay);
                }
                if (i == 3) {
                    arrayAdapter_time = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, Carnival);
                }

                if (i == 4) {
                    arrayAdapter_time = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, Multiplex);
                }
                if (i == 5) {
                    arrayAdapter_time = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, Maratha);
                }

                timeSpinner.setAdapter(arrayAdapter_time);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        bookBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent bookIntent = new Intent(Content_List_Activity.this, SeatBookActivity.class);
                String timeSlot = timeSpinner.getSelectedItem().toString();
                bookIntent.putExtra("timeSlot",timeSlot);
                startActivity(bookIntent);
            }
        });


    }
}