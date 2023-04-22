package com.meriniguan.kpdplus.data.users

interface UsersRepository {

    suspend fun isSignedIn(): Boolean

    suspend fun getCurrentUser(): User?

}