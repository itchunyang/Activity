package com.example.itchunyang.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;

/**
 * 旋转屏幕
 * onPause()->onSaveInstanceState()->onStop()->onDestroy()->onCreate()->onStart()->onRestoreInstanceState()->onResume()
 *
 * Home键
 * onPause()->onSaveInstanceState()->onStop();  onRestart()->onStart()->onResume();
 *
 * 启动其他Activity
 * onPause()->onSaveInstanceState()->onStop(); onRestart()->onStart()->onResume();
 *
 * 锁屏
 * onPause()->onSaveInstanceState()->onStop(); onRestart()->onStart()->onResume();
 */

public class LifeActivity extends Activity {

    public static final String TAG = LifeActivity.class.getSimpleName();
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life);
        Log.i(TAG, "onCreate: ");
    }

    //当某个activity变得“容易”被系统销毁时，该activity的onSaveInstanceState就会被执行
    //通常onSaveInstanceState()只适合用于保存一些临时性的状态，而onPause()适合用于数据的持久化保存。
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        Log.i(TAG, "onSaveInstanceState: ");
        super.onSaveInstanceState(outState);
    }

    //onRestoreInstanceState被调用的前提是，activity A“确实”被系统销毁了，而如果仅仅是停留在有这种可能性的情况下，则该方法不会被调用
    //onRestoreInstanceState的bundle参数也会传递到onCreate方法中
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        Log.i(TAG, "onRestoreInstanceState: ");

        //此方法的默认实现会自动保存activity中的某些状态数据,比如activity中各种UI控件的状态.
        //注意:开发者需要为这些控件指定一个唯一的ID,否则不能恢复
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        Log.i(TAG, "onSaveInstanceState: ");
        super.onSaveInstanceState(outState, outPersistentState);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState, PersistableBundle persistentState) {
        Log.i(TAG, "onRestoreInstanceState: ");
        super.onRestoreInstanceState(savedInstanceState, persistentState);
    }


    //在此Activity可见（显示在前台）之前调用。
    @Override
    protected void onStart() {
        Log.i(TAG, "onStart: ");
        super.onStart();
    }

    //在与用户进行交互之前调用此方法，这一时刻Activity位于activity栈的栈顶，在等待用户的操作（输入数据或点击按钮等）
    @Override
    protected void onResume() {
        Log.i(TAG, "onResume: ");
        super.onResume();
    }

    //处于停止态的Activity调用此方法，可以让此Activity重新显示在前台。
    @Override
    protected void onRestart() {
        Log.i(TAG, "onRestart: ");
        super.onRestart();
    }

    //多数情况下意味着用户要离开这个Activity，很快进入停止状态。
    //以下两种情况下 都只会触发onPause而不会触发onStop
    //1. 一个透明的包含Dialog的Activity 出现
    //2. 按poweroff锁屏
    @Override
    protected void onPause() {
        Log.i(TAG, "onPause: ");
        super.onPause();
    }

    //当Activity不可见时调用此方法
    @Override
    protected void onStop() {
        Log.i(TAG, "onStop: ");
        super.onStop();
    }

    //Activity被销毁时调用此方法
    @Override
    protected void onDestroy() {
        Log.i(TAG, "onDestroy: ");
        super.onDestroy();
    }

    public void startOther(View view) {
        startActivity(new Intent(this,Main2Activity.class));
    }
}
