package com.knightcoder.di

import com.knightcoder.data.MessageDataSource
import com.knightcoder.data.MessageDataSourceImpl
import com.knightcoder.room.RoomController
import com.mongodb.MongoClientSettings
import com.mongodb.MongoCredential
import com.mongodb.ServerAddress
import com.mongodb.reactivestreams.client.MongoClients
import org.koin.dsl.module
import org.litote.kmongo.coroutine.coroutine
import org.litote.kmongo.reactivestreams.KMongo


val mainModule = module {
    single {
        KMongo.createClient("mongodb://mongadmin:Amit%40007@192.168.0.105:27017/")
            .coroutine
            .getDatabase("message_db")
    }
    single<MessageDataSource> {
        MessageDataSourceImpl(get())
    }
    single {
        RoomController(get())
    }
}