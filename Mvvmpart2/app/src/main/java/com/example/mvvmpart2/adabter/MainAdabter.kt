package com.example.mvvmpart2.adabter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmpart2.databinding.ListItemBinding
import com.example.mvvmpart2.model.UserModel

class MainAdabter(val data: MutableList<UserModel>) : RecyclerView.Adapter<MainAdabter.ViewHolder> () {

    inner class ViewHolder(val binding:ListItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ListItemBinding.inflate(LayoutInflater.from(parent.context), parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.apply {
            TvNama.text = data[position].nama
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    fun setData(item: List<UserModel>) {
        data.clear()
        data.addAll(item)
        notifyDataSetChanged()
    }
}