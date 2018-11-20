package com.example.elshafie.interviewforecasttask;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.elshafie.interviewforecasttask.Model.Weather;
import com.example.elshafie.interviewforecasttask.Model.WhetherResult;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private AdapterWhether adapterWhether;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        adapterWhether = new AdapterWhether(MainActivity.this);
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
