package com.example.itchunyang.activity.launchmode;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.example.itchunyang.activity.LoginActivity;
import com.example.itchunyang.activity.R;

public class SingleInstanceActivity extends AppCompatActivity {

    public static final String TAG = SingleInstanceActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_instance);
        setTitle("SingleInstanceActivity");
        Log.i(TAG, "launchMode: taskid="+getTaskId());

    }

    public void start(View view) {
        startActivity(new Intent(this, LoginActivity.class));
    }
}
