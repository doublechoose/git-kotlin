package com.example.administrator.gitkotlin;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/**
 * Created by Administrator on 2019/2/2.
 */

public class LooperThread extends Thread {

    public Handler mHandler;

    @Override
    public void run() {
        Looper.prepare();

        mHandler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);

                System.out.println("handle message : "+msg);
            }
        };

        Looper.loop();
    }
}
