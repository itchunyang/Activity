package com.example.itchunyang.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    EditText et_user,et_passwd;
    public static final String TAG = LoginActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        et_user = (EditText) findViewById(R.id.et_user);
        et_passwd = (EditText) findViewById(R.id.et_passwd);

        Log.i(TAG, "launchMode: taskid="+getTaskId());

    }

    public void cancel(View view) {
        setResult(RESULT_CANCELED);
        finish();
    }

    public void login(View view) {
        String user = et_user.getText().toString();
        String passwd = et_passwd.getText().toString();

        Intent intent = new Intent();
        intent.putExtra("user",user);
        intent.putExtra("passwd",passwd);

        //setResult后结果并不会马上返回给parent的Activity,只有当前Activity被finish才会返回去(finish()方法里面执行返回结果的!)

        //那么如果在如下方法中调用setResult()也有可能不会返回成功： onPause()， onStop()， onDestroy(),
        //因为这些方法一般是在finish之后的

        //按BACK键从一个Activity退出来时,android就会自动调用Activity的finish()方法，然后设置resultCode为RESULT_CANCELED!
        //解决方法就是在Activity里面捕获按BACK的事件，捕获到之后先setResult，然后自己来调用finish,
        setResult(RESULT_OK,intent);

        //finish（）方法用于结束一个Activity的生命周期
        finish();
    }
}
