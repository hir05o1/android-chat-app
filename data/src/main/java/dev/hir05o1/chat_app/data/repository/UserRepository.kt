package dev.hir05o1.chat_app.data.repository

import dev.hir05o1.chat_app.data.dao.UserDao
import dev.hir05o1.chat_app.data.models.UserModel
import kotlinx.coroutines.flow.Flow

class UserRepository(
    private val userDao: UserDao
) {
    suspend fun insertUser(user: UserModel): Long = userDao.insert(user)
    suspend fun updateUser(user: UserModel) = userDao.update(user)
    suspend fun getAllUsers(): Flow<List<UserModel>> = userDao.observeAll()
}
