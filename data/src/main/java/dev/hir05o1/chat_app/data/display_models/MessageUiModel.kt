package dev.hir05o1.chat_app.data.display_models

import dev.hir05o1.chat_app.data.models.UserModel

data class MessageUiModel(
    val messageId: Int,
    val content: String,
    val user: UserModel,
    val createdAt: String,
    val reactions: List<ReactionUiModel>
)
