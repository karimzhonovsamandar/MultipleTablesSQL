package com.sammy.multipletablessql

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.sammy.multipletablessql.adapter.UniversalAdapter
import com.sammy.multipletablessql.databinding.ActivitySotuvchiXaridorBinding
import com.sammy.multipletablessql.db.MyDbHelper
import com.sammy.multipletablessql.models.Sotuvchi
import com.sammy.multipletablessql.models.Xaridor

class XaridorActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySotuvchiXaridorBinding

    lateinit var myDbHelper: MyDbHelper

    lateinit var universalAdapter: UniversalAdapter<Xaridor>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySotuvchiXaridorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.addressEditText.visibility = View.VISIBLE

        myDbHelper = MyDbHelper(this)

        universalAdapter = UniversalAdapter(myDbHelper.getAllXaridor())

        binding.rv.adapter = universalAdapter
2
        binding.apply {
            saveButton.setOnClickListener {
                val xaridor = Xaridor(
                    nameEditText.text.toString(),
                    phoneEditText.text.toString(),
                    addressEditText.text.toString()
                )

                myDbHelper.addXarirod(xaridor)
                universalAdapter.list.add(xaridor)
                universalAdapter.notifyItemInserted(universalAdapter.list.size - 1)
                Toast.makeText(this@XaridorActivity, "Saved", Toast.LENGTH_SHORT).show()

            }
        }
    }
}