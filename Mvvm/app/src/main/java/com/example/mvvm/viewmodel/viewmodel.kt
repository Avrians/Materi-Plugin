package com.example.mvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvm.Model.Dataname

class viewmodel : ViewModel() {

    var data : MutableLiveData<Dataname> = MutableLiveData()
    private val result_data : LiveData<Dataname> get() = data

    fun setData(dataName : Dataname) {
        data.value = dataName
    }

}