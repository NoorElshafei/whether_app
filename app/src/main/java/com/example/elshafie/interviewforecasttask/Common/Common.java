package com.example.elshafie.interviewforecasttask.Common;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

/**
 * Created by Elshafie on 11/17/2018.
 */

public class Common {
public static final String APP_ID="http://api.openweathermap.org/data/2.5/weather?id=524901&APPID=1252f97507d10d0c319b69c793d16c3d";

    public static String convertUnixToDate(long dt) {
        Date date=new Date(dt*1000L);
        SimpleDateFormat sdf=new SimpleDateFormat("HH:mm EEE MM yyyy");
        String formatted=sdf.format(date);
        return formatted;
    }


    public static String convertUnixToHour(long dt) {
        Date date=new Date(dt*1000L);
        SimpleDateFormat sdf=new SimpleDateFormat("HH:mm");
        String formatted=sdf.format(date);
        return formatted;
    }
}
