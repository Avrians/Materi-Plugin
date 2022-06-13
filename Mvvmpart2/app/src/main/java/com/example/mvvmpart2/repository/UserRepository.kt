package com.example.mvvmpart2.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.mvvmpart2.model.UserModel
import com.example.mvvmpart2.room.SetupRoomDB
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserRepository {
    companion object{
        var database: SetupRoomDB? = null
        var liveData: LiveData<List<UserModel>>? = null

        fun initDB(context: Context) : SetupRoomDB {
            return SetupRoomDB.invoke(context)
        }

        fun show(context: Context) : LiveData<List<UserModel>>? {
            database = initDB(context)
            liveData = database!!.dao().getAllData()
            return liveData
        }

        fun insert(context: Context, nama: String, prodi: String) {
            database = initDB(context)
            CoroutineScope(Dispatchers.IO).launch {
                database!!.dao().insertData(UserModel(0, nama, prodi))
            }
        }
    }
}