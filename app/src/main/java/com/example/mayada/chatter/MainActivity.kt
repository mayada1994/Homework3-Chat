package com.example.mayada.chatter

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.IllegalArgumentException

class MainActivity : AppCompatActivity() {
    private val messages: ArrayList<Message> = ArrayList()
    private val messageAdapter: MessageAdapter = MessageAdapter(messages)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        messages_recycler_view.layoutManager = LinearLayoutManager(this)
        messages_recycler_view.adapter = messageAdapter
        buttonOK.setOnClickListener {
            val currentText = edit_message.text.toString()
            val currentUser = when (radio_group.checkedRadioButtonId) {
                R.id.user1Select -> 1
                R.id.user2Select -> 2
                else -> throw IllegalArgumentException()
            }
            messageAdapter.postMessage(Message(currentUser, currentText))
            messageAdapter.notifyItemRangeChanged(0, messageAdapter.getItemCount());
            edit_message.text.clear()
        }
    }
}