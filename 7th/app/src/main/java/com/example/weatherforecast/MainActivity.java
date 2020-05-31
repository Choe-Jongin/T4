package com.example.weatherforecast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.ListFragment;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> cities = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cities.add("서울");
        cities.add("부산");
        cities.add("대전");
        cities.add("울산");

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, cities);
        ListFragment menuListFrgmt = (ListFragment)getSupportFragmentManager().findFragmentById(R.id.fragment);
        menuListFrgmt.setListAdapter(adapter) ;

    }

}
