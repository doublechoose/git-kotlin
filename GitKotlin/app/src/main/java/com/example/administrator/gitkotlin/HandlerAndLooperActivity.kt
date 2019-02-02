package com.example.administrator.gitkotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.util.Log
import android.widget.Toast

class HandlerAndLooperActivity : AppCompatActivity() {

//    表示可以有多个handler，但用的Looper仅有一个
    val handler = object : Handler() {

        override fun handleMessage(msg: Message?) {
            super.handleMessage(msg)
            if (msg?.what == 0) {
                Log.d("handler","handler")
                Toast.makeText(applicationContext, "子线程消息", Toast.LENGTH_LONG).show()
            }
        }
    }

    val handler1 = object : Handler() {

        override fun handleMessage(msg: Message?) {
            super.handleMessage(msg)
            if (msg?.what == 2) {
                Log.d("handler1","handler1")
                Toast.makeText(applicationContext, "子线程消息1", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun myThread(what:Int,handler: Handler):Thread {
        return Thread(Runnable {
            kotlin.run {
                var message = Message()
                message.what = what
                handler.sendMessage(message)
            }
        })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_handler_and_looper)

        myThread(2,handler1).start()

        myThread(0,handler).start()

    }

}
