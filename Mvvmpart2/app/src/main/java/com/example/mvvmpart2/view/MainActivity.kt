package com.example.mvvmpart2.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvmpart2.R
import com.example.mvvmpart2.adabter.MainAdabter
import com.example.mvvmpart2.databinding.ActivityMainBinding
import com.example.mvvmpart2.viewmodel.UserViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var userViewModel : UserViewModel
    lateinit var mainAdabter : MainAdabter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainAdabter = MainAdabter(mutableListOf())
        binding.Recycler.apply {
            adapter = mainAdabter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }

        userViewModel = ViewModelProvider(this).get(userViewModel::class.java)
        userViewModel.show(this)?.observe(this, {
            mainAdabter.setData(it)
        })

    }
}