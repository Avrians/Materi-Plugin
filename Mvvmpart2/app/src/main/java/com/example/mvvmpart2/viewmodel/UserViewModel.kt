package com.example.mvvmpart2.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmpart2.model.UserModel
import com.example.mvvmpart2.repository.UserRepository

class UserViewModel : ViewModel() {

    var liveData: LiveData<List<UserModel>>? = null

    fun show(context: Context) : LiveData<List<UserModel>>? {
        liveData = UserRepository.show(context)
        return liveData
    }

    fun insert(context: Context, nama: String, prodi: String) {
        UserRepository.insert(context, nama, prodi)
    }
}