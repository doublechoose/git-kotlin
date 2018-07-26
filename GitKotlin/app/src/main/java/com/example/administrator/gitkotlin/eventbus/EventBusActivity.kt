package com.example.administrator.gitkotlin.eventbus

import android.app.PendingIntent.getActivity
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.administrator.gitkotlin.R
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_event_bus.*
import org.greenrobot.eventbus.ThreadMode



class EventBusActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event_bus)

        val button = findViewById<Button>(R.id.bt_kotlin_base)
        button.setOnClickListener({
            EventBus.getDefault().post(MessageEvent("Hello everyone!"))
        })
    }


    // This method will be called when a MessageEvent is posted (in the UI thread for Toast)
    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onMessageEvent(event: MessageEvent) {
        Toast.makeText(this, event.message, Toast.LENGTH_SHORT).show()
        text_view.text = event.message
    }

    // This method will be called when a SomeOtherEvent is posted
    @Subscribe
    fun handleSomethingElse(event: SomeOtherEvent) {
        Toast.makeText(this, event.message, Toast.LENGTH_SHORT).show()
    }

    override fun onStart() {
        super.onStart()
        EventBus.getDefault().register(this)
    }

    override fun onStop() {
        super.onStop()
        EventBus.getDefault().unregister(this)
    }
}
