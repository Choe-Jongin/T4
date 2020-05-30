package com.example.weatherforecast;

import android.R.layout;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

import com.example.weatherforecast.R;

import java.util.ArrayList;

public class CityFragment extends ListFragment {
    public View onCreate(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View root = inflater.inflate(R.layout.fragment_city, container, false);

        ArrayList<String> cities = new ArrayList<String>();
        cities.add("서울");
        cities.add("부산");
        cities.add("대전");
        cities.add("울산");

        setListAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_activated_1, cities));
        ListView cityList = (ListView)root.findViewById(R.id.cityfrag);



        return root;
    }

}

