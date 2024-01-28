package com.sammy.multipletablessql

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.sammy.multipletablessql.adapter.BuyurtmaAdapter
import com.sammy.multipletablessql.databinding.ActivityBuyurtmaBinding
import com.sammy.multipletablessql.db.MyDbHelper
import com.sammy.multipletablessql.models.Buyurtma

class BuyurtmaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBuyurtmaBinding
    lateinit var myDbHelper: MyDbHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBuyurtmaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        myDbHelper = MyDbHelper(this)

        val sotuvchiList = myDbHelper.getAllSotuvchi()
        val xaridorList = myDbHelper.getAllXaridor()

        var sotuvchiNameList = ArrayList<String>()
        sotuvchiList.forEach {
            sotuvchiNameList.add(it.name!!)
        }
        val sa = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, sotuvchiNameList)
        binding.sotuvchiSpinner.adapter = sa


        var xaridorNameList = ArrayList<String>()
        xaridorList.forEach {
            xaridorNameList.add(it.name!!)
        }
        val xa = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, xaridorNameList)
        binding.xaridorSpinner.adapter = xa


        binding.apply {
            saveButton.setOnClickListener {
                val buyurtma = Buyurtma(
                    nameEditText.text.toString(),
                    sotuvchiList[sotuvchiSpinner.selectedItemPosition],
                    xaridorList[xaridorSpinner.selectedItemPosition]
                )
                myDbHelper.addBuyurtma(buyurtma)
                onResume()
                Toast.makeText(this@BuyurtmaActivity, "save", Toast.LENGTH_SHORT).show()
            }
        }


    }

    override fun onResume() {
        super.onResume()
        binding.rv.adapter = BuyurtmaAdapter(myDbHelper.getAllBuyurtma())
    }

}