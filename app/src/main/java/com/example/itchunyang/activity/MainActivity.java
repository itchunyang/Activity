package com.example.itchunyang.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.example.itchunyang.activity.launchmode.SingleInstanceActivity;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    /**
     * requestCode请求码的作用:用于标识请求来源
     *
     * 例如：一个Activity有两个按钮，点击这两个按钮都会打开同一个Activity，不管是那个按钮打开新Activity，当这个新Activity关闭后，
     * 系统都会调用前面Activity的onActivityResult(int requestCode, int resultCode, Intent data)方法。
     * 在onActivityResult()方法如果需要知道新Activity是由那个按钮打开的，并且要做出相应的业务处理，这时可以这样做：
     *   @Override protected void onActivityResult(int requestCode, int resultCode, Intent data) {
     *   switch(requestCode){
     *   case 1:
     *          来自按钮1的请求，作相应业务处理
     *   case 2:
     *          来自按钮2的请求，作相应业务处理
     *          }
     *   }
     *
     * resultCode结果码的作用:用于标记识结果来源
     *
     * 在一个Activity中，可能会使用startActivityForResult()方法打开多个不同的Activity处理不同的业务，当这些新Activity关闭后，
     * 系统都会调用前面Activity的onActivityResult(int requestCode, int resultCode, Intent data)方法。
     * 为了知道返回的数据来自于哪个新Activity，在onActivityResult()方法中可以这样做(ResultActivity和NewActivity为要打开的新Activity)：
     *
     * public class MainActivity extends Activity { // 在该Activity会打开ResultActivity和NewActivity
     * @Override protected void onActivityResult(int requestCode, int resultCode, Intent data) {
     *   switch(resultCode){
     *   case 1:
     *      ResultActivity的返回数据
     *   case 2:
     *      NewActivity的返回数据
     *      }
     *   }
     *}
     */

    //待验证 BActivity 设置Android:launchMode="singleInstance"    A,B将不会在同一个栈中，导致setResult(RESULT_OK);失败。
    //在一个Fragment中去使用startActivityForResult时，又是一个什么情况呢？
    //在安卓各生命周期内调用Activity.finish()方法后会经历哪些生命周期呢？
    private int requestCode = 100;
    public void startOtherResult(View view) {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivityForResult(intent, requestCode);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            String user = data.getStringExtra("user");
            String passwd = data.getStringExtra("passwd");

            Log.i(TAG, "onActivityResult: " + " requestCode=" + requestCode + " user=" + user + " passwd=" + passwd);
        }else{
            Log.i(TAG, "onActivityResult: 操作取消!");
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    /**
     *  1.standard
     *      不管当前Back Stack（回退栈）中有没有要启动的Activity实例，系统 都会将一个新的Activity实例放在栈顶。
     *
     *  2.singleTop
     *      当一个Activity的启动模式是singleTop时，如果当前Back Stack栈顶是要启动的Activity，那么就不会再创建一个Activity实例，而是直接显示当前栈顶的Activity，同时调用该Activity的onNewIntent()方法
     *
     *  3.singleTask
     *      整个Back Stack中最多只存在它的一个实例,会将Activity上面的Activity全部移除,同时调用该Activity的onNewIntent()方法
     *
     *  4.singleInstance 全局单例模式
     *      无论从哪个Task中启动目标Activity,只会创建一个目标Activity实例且会用一个全新的Task栈来装载该Activity实例.
     *      并保证不再有其他Activity实例进入!
     */
    public void launchMode(View view) {
//        Intent intent = new Intent(this, SingleTopActivity.class);
//        startActivity(intent);

//        Intent intent = new Intent(this, SingleTaskActivity.class);
//        startActivity(intent);

        Log.i(TAG, "launchMode: taskid="+getTaskId());
        Intent intent = new Intent(this, SingleInstanceActivity.class);
        startActivity(intent);
        //mainActivity--->SingleInstanceActivity--->LoginActivity
        //46                47                      46
    }

    public void life(View view) {
        startActivity(new Intent(this,LifeActivity.class));
    }
}
