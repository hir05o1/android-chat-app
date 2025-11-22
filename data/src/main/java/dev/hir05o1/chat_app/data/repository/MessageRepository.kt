package dev.hir05o1.chat_app.data.repository

import dev.hir05o1.chat_app.data.dao.MessageDao
import dev.hir05o1.chat_app.data.dao.UserDao
import dev.hir05o1.chat_app.data.models.MessageModel
import kotlinx.coroutines.flow.Flow

class MessageRepository(
    private val messageDao: MessageDao,
    private val userDao: UserDao,
) {
    suspend fun insertMessage(message: MessageModel): Long = messageDao.insert(message)
    fun getAllMessages(): Flow<List<MessageModel>> = messageDao.observeAll()
}
