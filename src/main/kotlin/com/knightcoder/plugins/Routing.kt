package com.knightcoder.plugins

import com.knightcoder.room.RoomController
import com.knightcoder.routes.chatSocket
import com.knightcoder.routes.getAllMessages
import io.ktor.routing.*
import io.ktor.application.*
import org.koin.ktor.ext.inject

fun Application.configureRouting() {
    val roomController by inject<RoomController>()
    install(Routing) {
        chatSocket(roomController)
        getAllMessages(roomController)
    }
}
