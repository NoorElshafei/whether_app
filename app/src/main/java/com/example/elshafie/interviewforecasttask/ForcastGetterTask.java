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

//connection with api and get all information about 5 days forecast whether from it


public abstract class ForcastGetterTask extends AsyncTask<Void, Void, List<WhetherResult>> {

    int id;

    public ForcastGetterTask(int id) {
        this.id = id;
    }

    @Override
    protected List<WhetherResult> doInBackground(Void... voids) {


        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;
        try {
            //connection with link of json code,but this id depend on which button user click on it to open match city
            URL url = new URL("http://api.openweathermap.org/data/2.5/forecast?id=" + id + "&APPID=1252f97507d10d0c319b69c793d16c3d");
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
        } finally {
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
        //get all information from jason code after connection


        List<WhetherResult> whetherList = new ArrayList<>();

        JSONObject rootObject = new JSONObject(response);


        JSONArray listJsonArray = rootObject.getJSONArray("list");
        for (int i = 0; i < listJsonArray.length(); i++) {
            JSONObject listJsonObject = listJsonArray.getJSONObject(i);
            WhetherResult whetherResult = new WhetherResult();

            //get name from jason code
            JSONObject cityJsonObject = rootObject.getJSONObject("city");
            whetherResult.setName(cityJsonObject.getString("name"));
            //get date and time from jason code
            whetherResult.setDtforecast(listJsonObject.getString("dt_txt"));
            //get icon from jason code
            JSONArray WhetherJsonArray = listJsonObject.getJSONArray("weather");
            JSONObject WhetherJsonObject = WhetherJsonArray.getJSONObject(0);
            whetherResult.getWeather().setIcon("https://openweathermap.org//img/w/" + WhetherJsonObject.getString("icon") + ".png");
            //get description from jason code
            whetherResult.getWeather().setDescription(WhetherJsonObject.getString("description"));
            //get temperature from jason code
            JSONObject MainJsonObject = listJsonObject.getJSONObject("main");
            whetherResult.getMain().setTemp(MainJsonObject.getDouble("temp"));
            //get pressure from jason code
            whetherResult.getMain().setPressure(MainJsonObject.getInt("pressure"));
            //get humidity from jason code
            whetherResult.getMain().setHumidity(MainJsonObject.getInt("humidity"));
            //get wind speed from jason code
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
