package com.example.elshafie.interviewforecasttask;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;
import android.widget.TextView;

import com.example.elshafie.interviewforecasttask.Model.WhetherResult;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.List;

/**
 * Created by Elshafie on 11/19/2018.
 */
//adapter of 5 days forecast whether recycler view
public class ForecastAdapter extends RecyclerView.Adapter<ForecastAdapter.forecastViewHolder> {
    private List<WhetherResult> whetherList;


    public ForecastAdapter() {
    }

    public void setForecastList(List<WhetherResult> whetherList) {
        this.whetherList = whetherList;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public forecastViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(parent.getContext()).inflate(R.layout.forcast_recycler_view, parent, false);
        ForecastAdapter.forecastViewHolder holder = new ForecastAdapter.forecastViewHolder(row);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull forecastViewHolder holder, int position) {
        final WhetherResult whetherResult = whetherList.get(position);
        //this statements for show information of 5 days forecast after get it from json

        holder.city_name.setText(whetherResult.getName());
        Picasso.with(holder.img_whether_icon.getContext()).load(whetherResult.getWeather().getIcon()).into(holder.img_whether_icon);
        DecimalFormat df = new DecimalFormat("#.##");
        holder.txt_temp.setText(new StringBuilder(String.valueOf(df.format(whetherResult.getMain().getTemp()))).append("°C").toString());
        holder.txt_time_date.setText(whetherResult.getDtforecast());
        holder.txt_pressure.setText(new StringBuilder(String.valueOf(whetherResult.getMain().getPressure())).append(" hpa").toString());
        holder.txt_humidty.setText(new StringBuilder(String.valueOf(whetherResult.getMain().getHumidity())).append(" %").toString());
        holder.txt_wind.setText(new StringBuilder(String.valueOf(whetherResult.getWind().getSpeed())).append(" m/s").toString());
        holder.txt_desc.setText(whetherResult.getWeather().getDescription());


    }

    @Override
    public int getItemCount() {
        return whetherList != null ? whetherList.size() : 0;
    }

    class forecastViewHolder extends RecyclerView.ViewHolder {
        ImageView img_whether_icon;
        TextView city_name, txt_wind, txt_pressure, txt_humidty, txt_temp, txt_time_date, txt_desc;


        public forecastViewHolder(View itemView) {
            super(itemView);

            img_whether_icon = itemView.findViewById(R.id.Image_Of_Whether);
            city_name = itemView.findViewById(R.id.Name_of_city_forecast);
            txt_wind = itemView.findViewById(R.id.txt_Wind);
            txt_pressure = itemView.findViewById(R.id.txt_Pressure);
            txt_humidty = itemView.findViewById(R.id.txt_Humidity);
            txt_temp = itemView.findViewById(R.id.Current_temp);
            txt_time_date = itemView.findViewById(R.id.Time_And_Date);
            txt_desc = itemView.findViewById(R.id.Whether_description);

        }

    }


}

