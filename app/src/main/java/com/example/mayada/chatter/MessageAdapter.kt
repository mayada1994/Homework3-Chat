package com.example.mayada.chatter

import android.provider.ContactsContract.CommonDataKinds.Relation.TYPE_FRIEND
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class MessageAdapter : RecyclerView.Adapter<MessageAdapter.ViewHolder>() {
    val messages = ArrayList<Message>()

    companion object {
        const val TYPE_FIRST_USER = 1
        const val TYPE_SECOND_USER = 2
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val layoutResource: Int = when (getItemViewType(viewType)) {
            TYPE_FIRST_USER -> R.layout.first_user_message
            else -> R.layout.second_user_message
        }

        val view: View = LayoutInflater.from(viewGroup.context).inflate(layoutResource, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItemViewType(position: Int): Int {
        val type = when (messages.get(position).user) {
            TYPE_FIRST_USER -> 1
            else -> 2
        }
        return type
    }

    override fun getItemCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }
}

