package com.example.itchunyang.activity.launchmode;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.itchunyang.activity.R;

public class SingleTask2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_task2);
    }

    public void start(View view) {
        startActivity(new Intent(this,SingleTaskActivity.class));
    }
}
