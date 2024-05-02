package com.knightcoder.data

import com.knightcoder.data.model.Message

interface MessageDataSource {

    suspend fun getAllMessages(): List<Message>

    suspend fun insertMessage(message: Message)
}