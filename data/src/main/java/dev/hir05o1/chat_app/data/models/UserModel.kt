package dev.hir05o1.chat_app.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class UserModel(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int = 0,

    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "avatarUrl")
    val avatarUrl: String? = null,

    @ColumnInfo(name = "createdAt")
    val createdAt: Long = System.currentTimeMillis()
)
