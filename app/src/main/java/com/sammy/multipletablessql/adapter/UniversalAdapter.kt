package com.sammy.multipletablessql.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sammy.multipletablessql.databinding.ItemRvBinding
import com.sammy.multipletablessql.models.Sotuvchi
import com.sammy.multipletablessql.models.Xaridor


class UniversalAdapter<T>(val list: ArrayList<T> = ArrayList()) : RecyclerView.Adapter<UniversalAdapter<T>.Vh>() {

    inner class Vh(var itemRvBinding: ItemRvBinding) : RecyclerView.ViewHolder(itemRvBinding.root) {

        fun onBindSotuvchi(sotuvchi: Sotuvchi) {
            itemRvBinding.tvName.text = sotuvchi.name
            itemRvBinding.tvPhone.text = sotuvchi.phone
        }

        fun onBindXaridor(xaridor: Xaridor) {
            itemRvBinding.tvName.text = xaridor.name
            itemRvBinding.tvPhone.text = xaridor.phone
            itemRvBinding.tvAddress.visibility = View.VISIBLE
            itemRvBinding.tvAddress.text = xaridor.address
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemRvBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        try {
            val sotuvchi = list[position] as Sotuvchi
            holder.onBindSotuvchi(sotuvchi)
        }catch (e:Exception){
            val xaridor = list[position] as Xaridor
            holder.onBindXaridor(xaridor)
        }

    }

}