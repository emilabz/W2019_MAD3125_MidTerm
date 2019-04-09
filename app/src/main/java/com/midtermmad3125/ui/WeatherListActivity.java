package com.midtermmad3125.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.midtermmad3125.R;
import com.midtermmad3125.models.Model;
import com.midtermmad3125.models.Temp;
import com.midtermmad3125.models.Weather;
import com.midtermmad3125.models.WeatherList;
import com.midtermmad3125.utils.WeatherAdapter;

import java.util.List;

public class WeatherListActivity extends AppCompatActivity
{
    private RecyclerView recyclerViewWeather;
    private RecyclerView.Adapter adapter;
    //private List<WeatherList> wlist;
    Model model;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_list);
        model= (Model) getIntent().getSerializableExtra("noname");
        //loadList();
        recyclerViewWeather=findViewById(R.id.rcvwWeather);
        recyclerViewWeather.setHasFixedSize(true);
        recyclerViewWeather.setLayoutManager(new LinearLayoutManager(this));
        adapter=new WeatherAdapter(model.wlist,this);
        recyclerViewWeather.setAdapter(adapter);
    }
    /*private void loadList(){
        Temp t=(new Temp(10.35,10.35,10.35,10.35,10.35,10.35));
        Weather w=new Weather(500,"Rain","light rain","10d");
        wlist.add(new WeatherList(t,1554714000,1013.11,90,w,5.44,184,92,2.44));
        wlist.add(new WeatherList(t,1554800400,1013.11,90,w,5.44,184,92,2.44));
        wlist.add(new WeatherList(t,1554714000,1013.11,90,w,5.44,184,92,2.44));
        wlist.add(new WeatherList(t,1554800400,1013.11,90,w,5.44,184,92,2.44));
        wlist.add(new WeatherList(t,1554714000,1013.11,90,w,5.44,184,92,2.44));

    }*/
}
