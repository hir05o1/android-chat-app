package dev.hir05o1.chat_app.data.display_models

import dev.hir05o1.chat_app.data.models.UserModel

data class ReactionUiModel(
    val content: String,
    val user: UserModel
)
