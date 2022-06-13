package com.example.mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm.Model.Dataname
import com.example.mvvm.databinding.ActivityMainBinding
import com.example.mvvm.viewmodel.viewmodel

class MainActivityMvvm : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var viewModel : viewmodel


    private var firtname = ""
    private var lastname = ""

    companion object {
        const val FN = "firstname"
        const val LN = "lastname"

}


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(viewmodel::class.java)
        viewModel.data.observe(this,{
            binding.tvResult.text = "hay... namaku ${it.firstname} ${it.lastname}"
        })

        binding.btnSimpan.setOnClickListener {
            viewModel.setData(Dataname(
                binding.etFirstname.text.toString(),
                binding.etLastname.text.toString()
                ))

        }
    }
}