package dev.hir05o1.chat_app.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "messages")
data class MessageModel(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val id: Int = 0,

    @ColumnInfo(name = "message") val message: String,

    @ColumnInfo(name = "userId") val userId: Int,

    @ColumnInfo(name = "replyId") val replyId: Int? = null,

    @ColumnInfo(name = "createdAt") val createdAt: Long = System.currentTimeMillis()
)
