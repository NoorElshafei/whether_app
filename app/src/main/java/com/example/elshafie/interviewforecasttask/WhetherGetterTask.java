package com.example.elshafie.interviewforecasttask;

import android.os.AsyncTask;
import com.example.elshafie.interviewforecasttask.Model.WhetherResult;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by Elshafie on 11/19/2018.
 */

public abstract class WhetherGetterTask extends AsyncTask<Void, Void, List<WhetherResult>> {
    @Override
    protected List<WhetherResult> doInBackground(Void... voids) {
        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;
        try {
            URL url = new URL("http://api.openweathermap.org/data/2.5/group?id=524901,703448,2643743,360630,4379545&APPID=1252f97507d10d0c319b69c793d16c3d");
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();


            InputStream inputStream = urlConnection.getInputStream();
            StringBuilder buffer = new StringBuilder();
            if (inputStream == null) {
                return null;
            }
            reader = new BufferedReader(new InputStreamReader(inputStream));

            String line;
            while ((line = reader.readLine()) != null) {
                buffer.append(String.format("%s\n", line));
            }

            if (buffer.length() == 0) {
                return null;
            }

            String response = buffer.toString();
            List<WhetherResult> whetherList = parseMovies(response);

            return whetherList;


        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally{
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (final IOException e) {

                }
            }
        }
    }

    private List<WhetherResult> parseMovies(String response) throws Exception {


        List<WhetherResult> whetherList = new ArrayList<>();

        JSONObject rootObject = new JSONObject(response);

        JSONArray listJsonArray = rootObject.getJSONArray("list");
        for (int i = 0; i < listJsonArray.length(); i++) {
            JSONObject listJsonObject = listJsonArray.getJSONObject(i);
            WhetherResult whetherResult = new WhetherResult();


            whetherResult.setName(listJsonObject.getString("name"));
            ////////////////
            whetherResult.setDt(listJsonObject.getInt("dt"));
            /////////////////
            JSONArray WhetherJsonArray = listJsonObject.getJSONArray("weather");
            JSONObject WhetherJsonObject = WhetherJsonArray.getJSONObject(0);
            whetherResult.getWeather().setIcon("https://openweathermap.org//img/w/" + WhetherJsonObject.getString("icon") + ".png");
            ////////////
            whetherResult.getWeather().setDescription(WhetherJsonObject.getString("description"));
            ////////
            JSONObject MainJsonObject = listJsonObject.getJSONObject("main");
            whetherResult.getMain().setTemp(MainJsonObject.getDouble("temp"));
            ////////
            whetherResult.getMain().setPressure(MainJsonObject.getInt("pressure"));
            ///////
            whetherResult.getMain().setHumidity(MainJsonObject.getInt("humidity"));
            ////////
            JSONObject SysJsonObject = listJsonObject.getJSONObject("sys");
            whetherResult.getSys().setSunrise(SysJsonObject.getLong("sunrise"));
            /////////////
            whetherResult.getSys().setSunset(SysJsonObject.getLong("sunset"));
            ///////
            whetherResult.getSys().setCountry(SysJsonObject.getString("country"));
            ///////
            JSONObject WindJsonObject = listJsonObject.getJSONObject("wind");
            whetherResult.getWind().setSpeed(WindJsonObject.getDouble("speed"));


            whetherList.add(whetherResult);
        }


        return whetherList;
    }

    @Override
    protected void onPostExecute(List<WhetherResult> whetherResults) {
        super.onPostExecute(whetherResults);
    }
}
