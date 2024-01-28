package com.sammy.multipletablessql

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.sammy.multipletablessql.adapter.UniversalAdapter
import com.sammy.multipletablessql.databinding.ActivitySotuvchiXaridorBinding
import com.sammy.multipletablessql.db.MyDbHelper
import com.sammy.multipletablessql.models.Sotuvchi

class SotuvchiActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySotuvchiXaridorBinding
    lateinit var myDbHelper: MyDbHelper

    lateinit var universalAdapter: UniversalAdapter<Sotuvchi>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySotuvchiXaridorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        myDbHelper = MyDbHelper(this)

        universalAdapter = UniversalAdapter(myDbHelper.getAllSotuvchi())

        binding.rv.adapter = universalAdapter

        binding.apply {

            saveButton.setOnClickListener {

                val sotuvchi = Sotuvchi(
                    nameEditText.text.toString(),
                    phoneEditText.text.toString()
                )

                myDbHelper.addSotuvchi(sotuvchi)
                universalAdapter.list.add(sotuvchi)
                universalAdapter.notifyItemInserted(universalAdapter.list.size - 1)
                Toast.makeText(this@SotuvchiActivity, "Saved", Toast.LENGTH_SHORT).show()

            }

        }

    }

}