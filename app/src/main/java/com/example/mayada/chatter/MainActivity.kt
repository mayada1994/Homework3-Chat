package com.example.mayada.chatter

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.chat_header.*
import kotlinx.android.synthetic.main.first_user_message.*
import java.lang.IllegalArgumentException

class MainActivity : AppCompatActivity() {
    private var messages: ArrayList<Message> = ArrayList()
    private var messageAdapter: MessageAdapter = MessageAdapter(messages)

    private var user1AmountOfMessages: Int = 0
    private var user2AmountOfMessages: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        HeaderInfo()
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
            messageAdapter.notifyDataSetChanged()
            edit_message.text.clear()
            HeaderInfo()
        }
    }

    fun HeaderInfo()
    {
        user1AmountOfMessages = messages.filter { it.messageUser == 1 }.count()
        user2AmountOfMessages = messages.filter { it.messageUser == 2 }.count()
        var user1Display: String = resources.getString(R.string.user_1) + ": " + user1AmountOfMessages.toString()
        var user2Display: String = resources.getString(R.string.user_2) + ": " + user2AmountOfMessages.toString()
        first_user_count.text = user1Display
        second_user_count.text = user2Display
    }
}