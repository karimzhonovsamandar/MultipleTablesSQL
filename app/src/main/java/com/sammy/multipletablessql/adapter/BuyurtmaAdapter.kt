package com.sammy.multipletablessql.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sammy.multipletablessql.databinding.ItemBuyurtmaBinding
import com.sammy.multipletablessql.models.Buyurtma

class BuyurtmaAdapter(val list: ArrayList<Buyurtma>) : RecyclerView.Adapter<BuyurtmaAdapter.Vh>() {

    inner class Vh(var itemBuyurtmaBinding: ItemBuyurtmaBinding) : RecyclerView.ViewHolder(itemBuyurtmaBinding.root) {

        fun onBind(buyurtma: Buyurtma, position: Int) {
            itemBuyurtmaBinding.tvName.text = buyurtma.name
            itemBuyurtmaBinding.tvDate.text = buyurtma.date
            itemBuyurtmaBinding.tvSotuvchi.visibility = View.VISIBLE
            itemBuyurtmaBinding.tvSotuvchi.text = buyurtma.sotuvchi?.name
            itemBuyurtmaBinding.tvXaridor.visibility = View.VISIBLE
            itemBuyurtmaBinding.tvXaridor.text = buyurtma.xaridor?.name
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemBuyurtmaBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position], position)

    }

}