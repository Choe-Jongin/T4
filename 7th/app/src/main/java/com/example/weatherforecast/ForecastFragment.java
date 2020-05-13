package com.example.weatherforecast;

import androidx.fragment.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class ForecastFragment extends Fragment {

    private ListView listview;
    private ArrayList<String> list = new ArrayList<>();
    private ArrayAdapter<String> adapter;


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        listview = (ListView)getView().findViewById(R.id.listView) ;
        list.add("서울");
        list.add("화성");

        adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, list);
        listview.setAdapter(adapter);


        return inflater.inflate(R.layout.frag_fore, container, false);
    }
}
