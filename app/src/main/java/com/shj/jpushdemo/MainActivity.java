package com.shj.jpushdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import cn.jpush.android.api.CustomPushNotificationBuilder;
import cn.jpush.android.api.JPushInterface;

/**
 * Created by Administrator on 15-7-21.
 */
public class MainActivity extends Activity {
    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item);
        text = ((TextView) findViewById(R.id.text));
        Bundle extra=getIntent().getExtras();
        Log.v("TAG", extra.toString());
        if(extra!=null){
            text.setText(extra.getString(JPushInterface.EXTRA_ALERT));
            Log.v("TAG", JPushInterface.EXTRA_ALERT);
        }
       CustomPushNotificationBuilder builder=new CustomPushNotificationBuilder(this,R.layout.custom,R.id.img,R.id.title,R.id.text);
//        builder.statusBarDrawable = R.drawable.ic_launcher;
//        // 指定最顶层状态栏小图标
//        builder.layoutIconDrawable = R.drawable.bottom_bg;
//        // 指定下拉状态栏时显示的通知图标
        JPushInterface.setPushNotificationBuilder(2, builder);


    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        JPushInterface.onResume(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        JPushInterface.onPause(this);
    }


}
