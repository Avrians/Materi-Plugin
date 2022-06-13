package com.example.mvvmpart2.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserModel(
    @PrimaryKey(autoGenerate = true)
    var id : Int,
    var nama: String,
    var prodi: String,

)
