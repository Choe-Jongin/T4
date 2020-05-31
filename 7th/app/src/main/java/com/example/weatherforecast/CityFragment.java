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
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.ListFragment;

import com.android.volley.VolleyError;
import com.example.weatherforecast.R;

import java.util.ArrayList;
import java.util.HashMap;


import com.android.volley.toolbox.Volley;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.RequestQueue;
import com.android.volley.Request;
import com.android.volley.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CityFragment extends ListFragment {

    static HashMap<String, Integer> cities = new HashMap<String, Integer>();
    void set() {
        cities.put("서울", 1835847);
        cities.put("대전", 1835224);
        cities.put("대구", 1835327);
        cities.put("부산", 1838519);

        ArrayAdapter adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_activated_1, cities.keySet().toArray());
        this.setListAdapter(adapter);
    };

    @Override
    public void onListItemClick (ListView l, View v, int position, long id) {
        // get TextView's Text.
        String strText = (String) l.getItemAtPosition(position) ;
        System.out.println( cities.get(strText));

        RequestQueue queue = Volley.newRequestQueue(getActivity());
        String url ="http://api.openweathermap.org/data/2.5/forecast/daily?id="+cities.get(strText)+"&cnt=16&appid=5fd2f2cde90c1533efb95b19c048a528";

        // Request a string response from the provided URL.
        JsonObjectRequest jsonObjectRequest
                = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                //JSONArray arr = response.getJSONArray("list");
                WeatherFragment weather = (WeatherFragment) getActivity().getSupportFragmentManager().findFragmentById(R.id.weather);
                weather.set(response);
                weather.getView().setVisibility(View.VISIBLE);

                getView().setVisibility(View.GONE);
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                // TODO: Handle error
            }

        });

        // Add the request to the RequestQueue.
        queue.add(jsonObjectRequest);


    }
}

