package dev.hir05o1.chat_app.data.usecase

import dev.hir05o1.chat_app.data.display_models.MessageUiModel
import dev.hir05o1.chat_app.data.models.MessageModel
import dev.hir05o1.chat_app.data.models.UserModel

object MessageUiMapper {
    fun toUi(message: MessageModel, user: UserModel?): MessageUiModel {
        val resolvedUser = user ?: UserModel(
            id = message.userId, name = "Unknown", avatarUrl = null, createdAt = message.createdAt
        )

        return MessageUiModel(
            messageId = message.id,
            content = message.message,
            user = resolvedUser,
            createdAt = java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
                .format(java.util.Date(message.createdAt)),
            reactions = emptyList() // ReactionRepository があればここでマップする
        )
    }
}
