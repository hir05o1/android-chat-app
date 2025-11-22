package dev.hir05o1.chat_app.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "reactions")
data class ReactionModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val content: String,
    val messageId: Int,
    val userId: Int,
    val createdAt: Long = System.currentTimeMillis(),
    val updatedAt: Long = System.currentTimeMillis()
)
