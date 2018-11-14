package com.example.mayada.chatter

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class MessageAdapter(var messages: ArrayList<Message>) : RecyclerView.Adapter<MessageAdapter.ViewHolder>() {

    companion object {
        const val TYPE_FIRST_USER = 1
        const val TYPE_SECOND_USER = 2
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val layoutResource: Int
        when (viewType) {

            TYPE_FIRST_USER -> layoutResource = R.layout.first_user_message
            else -> layoutResource = R.layout.second_user_message
        }

        val view: View = LayoutInflater.from(viewGroup.context).inflate(layoutResource, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.messageText.text = messages[position].messageText
        Log.i("T E S T I N G", "Items: ${messages.size}")
    }

    override fun getItemViewType(position: Int): Int {
        val type = when (messages[position].messageUser) {
            1 -> TYPE_FIRST_USER
            else -> TYPE_SECOND_USER
        }
        return type
    }

    override fun getItemCount(): Int {
        return messages.size
    }

    fun postMessage(message: Message) {
        messages.add(message)
        this.notifyItemInserted(messages.size - 1)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var messageText: TextView = itemView.findViewById(R.id.message_text)
    }
}

