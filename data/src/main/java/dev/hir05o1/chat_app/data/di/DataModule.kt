package dev.hir05o1.chat_app.data.di

import android.content.Context
import androidx.room.Room
import dev.hir05o1.chat_app.data.AppDatabase
import org.koin.dsl.module

private const val DB_NAME = "chat_app.db"

val dataModule = module {
    single { provideDatabase(get()) }
    single { get<AppDatabase>().userDao() }
    single { get<AppDatabase>().messageDao() }
    single { get<AppDatabase>().reactionDao() }
}

private fun provideDatabase(context: Context): AppDatabase = Room.databaseBuilder(
context,
AppDatabase::class.java,
DB_NAME
).fallbackToDestructiveMigration(false).build()

