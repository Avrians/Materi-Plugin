package com.example.mvvmpart2.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmpart2.databinding.ActivityCreateBinding
import com.example.mvvmpart2.viewmodel.UserViewModel

class CreateActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCreateBinding
    lateinit var userViewModel : UserViewModel
    lateinit var nama: String
    lateinit var prodi: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateBinding.inflate(layoutInflater)
        setContentView(binding.root)

        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        btnSave()
    }

    private fun btnSave() {
        binding.BtnSave.setOnClickListener {
            nama = binding.ETnama.text.toString()
            prodi = binding.ETProdi.text.toString()
            if (nama.isEmpty()){
                binding.ETnama.error = "Please enter name fill"
            } else if (prodi.isEmpty()){
                binding.ETProdi.error = "Please enter prodi fill"
            } else {
                userViewModel.insert(this,nama,prodi)
                Toast.makeText(applicationContext,"Create data succesfully", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, MainActivity::class.java).also {finish()})
            }
        }
    }
}