package com.midtermmad3125.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.midtermmad3125.R;
import com.midtermmad3125.models.Model;

public class WeatherListActivity extends AppCompatActivity
{
    Model model;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_list);
        model=(Model) getIntent().getSerializableExtra("Model");
    }
}
