package dev.hir05o1.chat_app.data.usecase

import dev.hir05o1.chat_app.data.display_models.MessageUiModel
import dev.hir05o1.chat_app.data.models.MessageModel
import dev.hir05o1.chat_app.data.repository.MessageRepository
import dev.hir05o1.chat_app.data.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine

class MessageUseCase(
    private val messageRepository: MessageRepository, private val userRepository: UserRepository
) {

    suspend fun getAllMessagesUi(): Flow<List<MessageUiModel>> {
        return messageRepository.getAllMessages()
            .combine(userRepository.getAllUsers()) { messages, users ->
                val usersById = users.associateBy { it.id }
                messages.map { msg -> MessageUiMapper.toUi(msg, usersById[msg.userId]) }
            }
    }

    suspend fun getMessagesForUserUi(userId: Int): Flow<List<MessageUiModel>> {
        return messageRepository.getAllMessages()
            .combine(userRepository.getAllUsers()) { messages, users ->
                val usersById = users.associateBy { it.id }
                messages.filter { it.userId == userId }
                    .map { msg -> MessageUiMapper.toUi(msg, usersById[msg.userId]) }
            }
    }

    suspend fun sendMessage(content: String, userId: Int, replyId: Int?): Long {
        val model = MessageModel(
            message = content,
            userId = userId,
            replyId = replyId,
        )
        return messageRepository.insertMessage(model)
    }
}
