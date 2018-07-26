package com.example.administrator.gitkotlin

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.administrator.gitkotlin.eventbus.EventBusActivity
import com.example.administrator.gitkotlin.eventbus.MessageEvent
import org.greenrobot.eventbus.EventBus

class KotlinBaseActivity : AppCompatActivity() {

    private var count = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin_base)

        val button = findViewById<Button>(R.id.bt_kotlin_base)
        button.setOnClickListener({
            EventBus.getDefault().post(MessageEvent("Hello everyone!"+count++))
        })
        val button2 = findViewById<Button>(R.id.bt_activity)
        button2.setOnClickListener {
            val inten = Intent(KotlinBaseActivity@this,EventBusActivity::class.java)
            KotlinBaseActivity@this.startActivity(inten)
        }
    }
}
