package com.midtermmad3125.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.widget.TextView;

import com.midtermmad3125.R;
import com.midtermmad3125.models.City;
import com.midtermmad3125.models.Model;
import com.midtermmad3125.utils.ReadJSONUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainCityActivity extends AppCompatActivity
{
    Model m=new Model();
    TextView txtCity;
    TextView txtLat;
    TextView txtLong;
    TextView txtCountry;
    TextView txtPopulation;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadJSON();
        txtCity=findViewById(R.id.txtCity);
        Intent mIntent=new Intent(getApplicationContext(),WeatherListActivity.class);
        //Intent.putExtra("Model", m);
    }
    public void loadJSON(){
        String jsonString=ReadJSONUtils.loadJSONFromAsset(this,"moscow_weather.json");
        if (jsonString!=null){
            try {
                JSONObject mjsonObject=new JSONObject(jsonString);
                if (mjsonObject.has("id")){
                    m.city.id=mjsonObject.getInt("id");
                    m.city.name=mjsonObject.getString("name");
                    m.city.coordinate.setLat(mjsonObject.getDouble("lat"));
                    m.city.coordinate.setLon(mjsonObject.getDouble("lon"));
                    m.city.countryCode=mjsonObject.getString("country");
                    m.city.population=Integer.toString( mjsonObject.getInt("population"));
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    }
}
