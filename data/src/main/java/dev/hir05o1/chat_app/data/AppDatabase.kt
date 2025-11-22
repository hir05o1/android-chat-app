package dev.hir05o1.chat_app.data

import androidx.room.Database
import androidx.room.RoomDatabase
import dev.hir05o1.chat_app.data.dao.MessageDao
import dev.hir05o1.chat_app.data.dao.ReactionDao
import dev.hir05o1.chat_app.data.dao.UserDao
import dev.hir05o1.chat_app.data.models.MessageModel
import dev.hir05o1.chat_app.data.models.ReactionModel
import dev.hir05o1.chat_app.data.models.UserModel

@Database(
    entities = [UserModel::class, MessageModel::class, ReactionModel::class],
    version = 1,
    exportSchema = true
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun messageDao(): MessageDao
    abstract fun reactionDao(): ReactionDao
}

