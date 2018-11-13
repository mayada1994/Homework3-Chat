package com.example.mayada.chatter

class Message {
    var user: Int = 0
    var text: String = ""
        get() = field
        set(value) {
            field = value
        }
}