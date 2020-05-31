package com.example.weatherforecast;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class WeatherFragment extends ListFragment {

    HashMap<String,String> item= new HashMap<String,String>();
    ArrayList<HashMap<String,String>> mem= new ArrayList<HashMap<String,String>>();

    private static String getTimestampToKrDate(long timestamp){
        Date date = new java.util.Date(timestamp*1000L);
        SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
        sdf.setTimeZone(java.util.TimeZone.getTimeZone("GMT+9"));
        String formattedDate = sdf.format(date);
        return formattedDate;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    void set(JSONObject obj) {

        item.clear();
        mem.clear();

        TextView tv = (TextView)getActivity().findViewById(R.id.desc);
        try {
            tv.setText(obj.getJSONObject("city").getString("name"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            JSONArray arr = obj.getJSONArray("list");
            for (int i = 0; i < arr.length(); i++) {
                item= new HashMap<String,String>();
                SimpleDateFormat format = new SimpleDateFormat ( "yyyy년 MM월dd일");
                JSONObject o = arr.getJSONObject(i);
                String temp = new String();

                item.put("item1",getTimestampToKrDate(o.getLong("dt")));
                temp += "[";
                temp += (o.getJSONObject("temp").getInt("max")-273.0);
                temp += "/";
                temp += (o.getJSONObject("temp").getInt("min")-273.0);
                temp += "] ";
                temp += o.getJSONArray("weather").getJSONObject(0).getString("description");

                item.put("item2", temp);
                mem.add(item);
            }


        } catch (JSONException e) {
            e.printStackTrace();
        }

        SimpleAdapter simpleAdapter = new SimpleAdapter(getActivity(), mem, android.R.layout.simple_list_item_2,
                new String[]{"item1","item2"}, new int[]{android.R.id.text1, android.R.id.text2});

        this.setListAdapter(simpleAdapter) ;
    }
}
