package com.meriniguan.kpdplus.data.users

import com.meriniguan.kpdplus.database.NODE_USERS
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.example.telegraml.utilits.AppValueEventListener

class FirebaseUsersRepository : UsersRepository {

    private val AUTH = FirebaseAuth.getInstance()
    private val REF_DATABASE_ROOT = FirebaseDatabase.getInstance("https://telegraml-default-rtdb.firebaseio.com/").reference
    private val CURRENT_UID = AUTH.currentUser?.uid.toString()

    override suspend fun isSignedIn(): Boolean {
        return AUTH.currentUser != null
    }

    override suspend fun getCurrentUser(): User? {
        var blabla: User? = null
        REF_DATABASE_ROOT.child(NODE_USERS).child(
            CURRENT_UID
        )
            .addListenerForSingleValueEvent(AppValueEventListener {
                blabla = it.getValue(User::class.java) ?: User()
            })
        return blabla
    }
}