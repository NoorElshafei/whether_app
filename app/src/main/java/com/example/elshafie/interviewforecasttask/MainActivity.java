package com.example.elshafie.interviewforecasttask;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.elshafie.interviewforecasttask.Model.Weather;
import com.example.elshafie.interviewforecasttask.Model.WhetherResult;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private AdapterWhether adapterWhether;
    public Weather weather=new Weather();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        adapterWhether = new AdapterWhether();


        recyclerView.setAdapter(adapterWhether);

        WhetherGetterTask whetherGetterTask = new WhetherGetterTask() {
            @Override
            protected void onPostExecute(List<WhetherResult> whetherResults) {
                adapterWhether.setWhetherList(whetherResults);

            }
        };
        whetherGetterTask.execute();


    }


}
