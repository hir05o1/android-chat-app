package dev.hir05o1.chat_app.data.di

import dev.hir05o1.chat_app.data.repository.MessageRepository
import dev.hir05o1.chat_app.data.repository.UserRepository
import dev.hir05o1.chat_app.data.usecase.MessageUseCase
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val domainModule = module {
    singleOf(::UserRepository)
    singleOf(::MessageRepository)
    singleOf(::MessageUseCase)
}
