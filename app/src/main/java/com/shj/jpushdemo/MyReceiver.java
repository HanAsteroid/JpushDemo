package com.shj.jpushdemo;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import cn.jpush.android.api.JPushInterface;

/**
 * Created by Administrator on 15-7-21.
 */
public class MyReceiver extends BroadcastReceiver {
    public MyReceiver() {
    }


    @Override
    public void onReceive(Context context, Intent intent) {

        if(JPushInterface.ACTION_NOTIFICATION_OPENED.equals(intent.getAction())){
            Intent intent1=new Intent(context,MainActivity.class);
            intent1.putExtras(intent.getExtras());
            intent1.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TOP);
            context.startActivity(intent1);
        }
       // throw new UnsupportedOperationException("Not yet implemented");

    }
}
