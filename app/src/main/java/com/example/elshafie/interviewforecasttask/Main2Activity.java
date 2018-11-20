package com.example.elshafie.interviewforecasttask;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.elshafie.interviewforecasttask.Model.WhetherResult;

import java.util.List;

//activity of 5 days forecast
public class Main2Activity extends AppCompatActivity {
    private RecyclerView recyclerView1;
    private ForecastAdapter forecastAdapter;
    private int s = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        recyclerView1 = findViewById(R.id.recyclerView1);
        recyclerView1.setLayoutManager(new LinearLayoutManager(Main2Activity.this));
        forecastAdapter = new ForecastAdapter();
        String a = getIntent().getExtras().getSerializable("WhetherResult").toString();


        recyclerView1.setAdapter(forecastAdapter);
        //this if statement for open the information of 5 days forecast depend on city
        //when user click on city , i store position of click and compare to open the  forecast of match city
        if (a.equals("0")) {
            s = 524901;
        } else if (a.equals("1")) {
            s = 703448;
        } else if (a.equals("2")) {
            s = 2643743;
        } else if (a.equals("3")) {
            s = 360630;
        } else if (a.equals("4")) {
            s = 4379545;
        }

        ForcastGetterTask forcastGetterTask = new ForcastGetterTask(s) {
            @Override
            protected void onPostExecute(List<WhetherResult> whetherResults) {
                forecastAdapter.setForecastList(whetherResults);
            }
        };
        forcastGetterTask.execute();
    }
}
