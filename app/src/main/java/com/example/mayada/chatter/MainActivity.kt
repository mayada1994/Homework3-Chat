package com.example.mayada.chatter

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import java.lang.IllegalArgumentException

class MainActivity : AppCompatActivity() {
    private val messages:ArrayList<Message> = ArrayList()
    private val messageAdapter: MessageAdapter = MessageAdapter(messages)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var editMessage = findViewById<EditText>(R.id.edit_message)
        var radioGroup = findViewById<RadioGroup>(R.id.radio_group)
        var messagesRecycler = findViewById<RecyclerView>(R.id.messages_recycler_view)
        messagesRecycler.layoutManager = LinearLayoutManager(this)
        messagesRecycler.adapter = this.messageAdapter
        val okButton: Button = findViewById(R.id.buttonOK)
        okButton.setOnClickListener {
            val checkedRadioButton = radioGroup.checkedRadioButtonId
            val currentText = editMessage.text.toString()
            val currentUser = when (checkedRadioButton) {
                R.id.user1Select -> 1
                R.id.user2Select -> 2
                else -> throw IllegalArgumentException()
            }
            messageAdapter.postMessage(Message(currentUser, currentText))
            editMessage.text.clear()
        }
    }
}