package com.midtermmad3125.utils;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.midtermmad3125.R;
import com.midtermmad3125.models.Weather;
import com.midtermmad3125.models.WeatherList;

import java.util.List;
import java.util.function.DoubleToIntFunction;

import static com.midtermmad3125.utils.ReadJSONUtils.getDateFromTimeStamp;

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.ViewHolder> {
    private List<WeatherList> wlist;
    private Context context;

    public WeatherAdapter(List<WeatherList> wlist, Context context) {
        this.wlist = wlist;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v= LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.weather_item,viewGroup,false);
        return new ViewHolder(v);
    }

    @Override
    public int getItemCount() {
        return wlist.size();
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        WeatherList w=wlist.get(i);
        viewHolder.txtMin.setText(""+w.t.getMin());
        viewHolder.txtMax.setText(""+w.t.getMin());
        viewHolder.txtDate.setText(getDateFromTimeStamp(w.dt));
        viewHolder.txtCondition.setText(w.w.main);
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView txtMin;
        public TextView txtMax;
        public TextView txtDate;
        public TextView txtCondition;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtMin=itemView.findViewById(R.id.txtMin);
            txtMax=itemView.findViewById(R.id.txtMax);
            txtDate=itemView.findViewById(R.id.txtDate);
            txtCondition=itemView.findViewById(R.id.txtCondition);
        }
    }
}
