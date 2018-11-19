package com.example.elshafie.interviewforecasttask;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.example.elshafie.interviewforecasttask.Common.Common;
import com.example.elshafie.interviewforecasttask.Model.Weather;
import com.example.elshafie.interviewforecasttask.Model.WhetherResult;
import com.squareup.picasso.Picasso;
import java.text.DecimalFormat;
import java.util.List;

/**
 * Created by Elshafie on 11/19/2018.
 */

public class AdapterWhether extends RecyclerView.Adapter<AdapterWhether.whetherViewHolder> {
    private List<WhetherResult> whetherList;


    public AdapterWhether() {
    }

    public void setWhetherList(List<WhetherResult> whetherList) {
        this.whetherList = whetherList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public whetherViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view, parent, false);
        whetherViewHolder holder = new whetherViewHolder(row);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull whetherViewHolder holder, int position) {

        WhetherResult whetherResult = whetherList.get(position);

        Picasso.with(holder.img_whether_icon.getContext()).load(whetherResult.getWeather().getIcon()).into(holder.img_whether_icon);
        DecimalFormat df = new DecimalFormat("#.##");
        holder.city_name.setText(whetherResult.getName());
        holder.txt_temp.setText(new StringBuilder(String.valueOf(df.format(whetherResult.getMain().getTemp()))).append("°C").toString());
        holder.txt_time_date.setText(Common.convertUnixToDate(whetherResult.getDt()));
        holder.txt_pressure.setText(new StringBuilder(String.valueOf(whetherResult.getMain().getPressure())).append(" hpa").toString());
        holder.txt_humidty.setText(new StringBuilder(String.valueOf(whetherResult.getMain().getHumidity())).append(" %").toString());
        holder.txt_wind.setText(new StringBuilder(String.valueOf(whetherResult.getWind().getSpeed())).append(" m/s").toString());
        holder.txt_sunrise.setText(Common.convertUnixToHour(whetherResult.getSys().getSunrise()));
        holder.txt_sunset.setText(Common.convertUnixToHour(whetherResult.getSys().getSunset()));
        holder.txt_Country.setText(whetherResult.getSys().getCountry());
        holder.txt_desc.setText(whetherResult.getWeather().getDescription());

    }

    @Override
    public int getItemCount() {
        return whetherList != null ? whetherList.size() : 0;
    }

    class whetherViewHolder extends RecyclerView.ViewHolder {
        ImageView img_whether_icon;
        TextView city_name, txt_wind, txt_pressure, txt_humidty, txt_sunrise, txt_sunset, txt_temp, txt_time_date,txt_Country,txt_desc;

        public whetherViewHolder(View itemView) {
            super(itemView);
            txt_Country=itemView.findViewById(R.id.Country);
            img_whether_icon = itemView.findViewById(R.id.Image_Of_Whether);
            city_name = itemView.findViewById(R.id.Name_Of_City);
            txt_wind = itemView.findViewById(R.id.txt_Wind);
            txt_pressure = itemView.findViewById(R.id.txt_Pressure);
            txt_humidty = itemView.findViewById(R.id.txt_Humidity);
            txt_sunrise = itemView.findViewById(R.id.txt_Sunrise);
            txt_sunset = itemView.findViewById(R.id.txt_Sunset);
            txt_temp = itemView.findViewById(R.id.Current_temp);
            txt_time_date = itemView.findViewById(R.id.Time_And_Date);
            txt_desc=itemView.findViewById(R.id.Whether_description);
        }

    }

}
