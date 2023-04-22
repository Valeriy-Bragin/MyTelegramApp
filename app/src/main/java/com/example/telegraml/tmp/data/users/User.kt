package com.meriniguan.kpdplus.data.users

data class User(
    val id: String = "",
    var name: String = "",
    var phone: String = "",
    var photoUrl: String = "empty",
    var bossId: String = ""
)