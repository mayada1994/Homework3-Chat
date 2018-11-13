package com.example.mayada.chatter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class MessageAdapter(var messages: ArrayList<Message>) : RecyclerView.Adapter<MessageAdapter.ViewHolder>() {

    var user1Messages:Int = 0
    var user2Messages:Int = 0
    companion object {
        const val TYPE_FIRST_USER = 1
        const val TYPE_SECOND_USER = 2
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val layoutResource: Int = when (getItemViewType(viewType)) {
            TYPE_FIRST_USER -> R.layout.first_user_message
            TYPE_SECOND_USER -> R.layout.second_user_message
            else -> throw IllegalArgumentException()
        }

        val view: View = LayoutInflater.from(viewGroup.context).inflate(layoutResource, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val message = messages[position]
        viewHolder.messageText.text = message.messageText

        viewHolder.firstUserMessages.setText(user1Messages)
        viewHolder.secondUserMessages.setText(user2Messages)

        when(message.messageUser)
        {
            1 -> user1Messages++
            2 -> user2Messages++
        }
    }

    override fun getItemViewType(position: Int): Int {
        val type = when (messages[position].messageUser) {
            1 -> TYPE_FIRST_USER
            2 -> TYPE_SECOND_USER
            else -> throw IllegalArgumentException()
        }
        return type
    }

    override fun getItemCount(): Int {
        return messages.size
    }

    fun postMessage(message: Message) {
        messages.add(message)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val messageText = itemView.findViewById<TextView>(R.id.message_text)
        val firstUserMessages = itemView.findViewById<TextView>(R.id.first_user_count)
        val secondUserMessages = itemView.findViewById<TextView>(R.id.second_user_count)
    }
}

