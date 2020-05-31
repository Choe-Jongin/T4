package com.example.weatherforecast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.ListFragment;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    CityFragment cityFragment;
    WeatherFragment weatherFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cityFragment = (CityFragment)getSupportFragmentManager().findFragmentById(R.id.fragment);
        cityFragment.set();


        weatherFragment = (WeatherFragment)getSupportFragmentManager().findFragmentById(R.id.weather);
        weatherFragment.set(new JSONObject());
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if ((keyCode == KeyEvent.KEYCODE_BACK))
        {
            cityFragment.getView().setVisibility(View.VISIBLE);
            weatherFragment.getView().setVisibility(View.GONE);
            TextView tv = (TextView)findViewById(R.id.desc);
            tv.setText("city list");
            return true; //I have tried here true also
        }
        return super.onKeyDown(keyCode, event);
    }
}
