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
        txtLat=findViewById(R.id.txtLat);
        txtLong=findViewById(R.id.txtLong);
        txtCountry=findViewById(R.id.txtCountry);
        txtPopulation=findViewById(R.id.txtPopulation);
        //txtCity.setText(m.city.name);
        //txtLat.setText(m.city.coordinate.getLat());
        //txtLong.setText(m.city.coordinate.getLon());
        //txtCountry.setText(m.city.countryCode);
        //txtPopulation.setText(m.city.population);
        Intent mIntent=new Intent(getApplicationContext(),WeatherListActivity.class);
        mIntent.putExtra("Model", m);
        startActivity(mIntent);
    }
    public void loadJSON(){
        String jsonString=ReadJSONUtils.loadJSONFromAsset(this,"moscow_weather.json");
        if (jsonString!=null){
            Log.d("--inside--","not null");
            try {
                JSONObject mjsonObject=new JSONObject(jsonString);
                if (mjsonObject.has("city")){
                    Log.d("--inside--","has city");
                    JSONObject cityObj=mjsonObject.getJSONObject("city");
                    if(cityObj.has("id")){
                        Log.d("--inside--","has id");
                        //m.city.id=cityObj.getInt("id");
                        m.city.name=cityObj.getString("name");
                        JSONObject coordObj=cityObj.getJSONObject("coord");
                        m.city.coordinate.setLat(coordObj.getDouble("lat"));
                        m.city.coordinate.setLon(coordObj.getDouble("lon"));
                        m.city.countryCode=cityObj.getString("country");
                        m.city.population=Integer.toString( cityObj.getInt("population"));
                        Log.d("---json---","id:"+m.city.id+" name: "+m.city.name);
                    }
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    }
}
