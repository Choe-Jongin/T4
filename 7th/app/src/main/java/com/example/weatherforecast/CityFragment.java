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
    /*
    public View onCreate(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_city, container, false);

        return root;
    }
    */
    @Override
    public void onListItemClick (ListView l, View v, int position, long id) {
        // get TextView's Text.
        String strText = (String) l.getItemAtPosition(position) ;
        // TODO
    }
}

