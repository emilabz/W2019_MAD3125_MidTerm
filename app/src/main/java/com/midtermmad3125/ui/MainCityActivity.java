package com.midtermmad3125.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.midtermmad3125.R;
import com.midtermmad3125.models.City;
import com.midtermmad3125.models.Model;
import com.midtermmad3125.models.Temp;
import com.midtermmad3125.models.Weather;
import com.midtermmad3125.models.WeatherList;
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
    Button btnTemp;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        System.out.println("OnCreate");
        loadJSON();
        txtCity=findViewById(R.id.txtCity);
        txtLat=findViewById(R.id.txtLat);
        txtLong=findViewById(R.id.txtLong);
        txtCountry=findViewById(R.id.txtCountry);
        txtPopulation=findViewById(R.id.txtPopulation);
        btnTemp=findViewById(R.id.btnTemp);

        txtCity.setText(m.city.name);
        txtLat.setText(m.city.coordinate.getLat().toString());
        txtLong.setText(m.city.coordinate.getLon().toString());
        txtCountry.setText(m.city.countryCode);
        txtPopulation.setText(m.city.population);
        //Intent mIntent=new Intent(getApplicationContext(),WeatherListActivity.class);
        //mIntent.putExtra("Model", m);
        //startActivity(mIntent);
        btnTemp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mIntent=new Intent(MainCityActivity.this,WeatherListActivity.class);
                mIntent.putExtra("noname", m);
                startActivity(mIntent);
            }
        });
    }
    public void loadJSON(){
        String jsonString=ReadJSONUtils.loadJSONFromAsset(this,"moscow_weather.json");
        if (jsonString!=null){
            Log.d("--inside--","not null");
            //System.out.println("not null");
            try {
                JSONObject mjsonObject=new JSONObject(jsonString);
                if(mjsonObject!=null){
                    if (mjsonObject.has("city")){
                        Log.d("--inside--","has city");
                        JSONObject cityObj=mjsonObject.getJSONObject("city");
                        if(cityObj!=null){
                            //System.out.println("id="+cityObj.getLong("id"));
                            m.city.id = cityObj.getLong("id");
                            if(cityObj.has("id")) {
                                Log.d("--inside--", "has id");
                                m.city.id = cityObj.getLong("id");
                                if (cityObj.has("name")) {
                                    System.out.println("name exists");
                                    m.city.name = cityObj.getString("name");
                                }
                            }
                        }
                        JSONObject coordObj=cityObj.getJSONObject("coord");
                        if(coordObj!=null){
                            m.city.coordinate.setLat(coordObj.getDouble("lat"));
                            m.city.coordinate.setLon(coordObj.getDouble("lon"));
                            m.city.countryCode=cityObj.getString("country");
                            m.city.population=Integer.toString( cityObj.getInt("population"));
                            Log.d("---json---","id:"+m.city.id+" name: "+m.city.name);
                        }
                    }
                    int count=mjsonObject.getInt("cnt");
                    System.out.println("count"+count);
                    JSONArray listArr=mjsonObject.getJSONArray("list");
                    if (listArr!=null){
                        for(int i=0;i<count;i++){
                            //System.out.println("inside for");
                            JSONObject listObj=listArr.getJSONObject(i);
                            Long dt=listObj.getLong("dt");
                            System.out.println("dt:"+dt);
                            JSONObject t=listObj.getJSONObject("temp");
                            Temp tObj=new Temp(t.getDouble("day"),t.getDouble("min"),t.getDouble("max"),t.getDouble("night"),t.getDouble("eve"),t.getDouble("morn"));
                            double pres=listObj.getDouble("pressure");
                            int humi=listObj.getInt("humidity");
                            JSONArray wArr=listObj.getJSONArray("weather");
                            JSONObject w=wArr.getJSONObject(0);
                            Weather wObj=new Weather(w.getInt("id"),w.getString("main"),w.getString("description"),w.getString("icon"));
                            Double speed=listObj.getDouble("speed");
                            int deg=listObj.getInt("deg");
                            int clouds=listObj.getInt("clouds");
                            Double rain=listObj.getDouble("rain");
                            m.wlist.add(new WeatherList(tObj,dt,pres,humi,wObj,speed,deg,clouds,rain));

                        }
                    }

                }
            } catch (JSONException e) {
                e.printStackTrace();
            }


        }
    }
}
