package com.example.mvvmpart2.room

import androidx.lifecycle.LiveData
import androidx.room.Insert
import androidx.room.Query
import com.example.mvvmpart2.model.UserModel

@Dao
interface Dao {

    @Insert
    suspend fun insertData(userModel: UserModel)

    @Query("SELECT * FROM UserModel")
    fun getAllData() : LiveData<List<UserModel>>
}
