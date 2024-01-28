package com.sammy.multipletablessql

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sammy.multipletablessql.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            sotuvchiTextView.setOnClickListener {
                startActivity(Intent(this@MainActivity, SotuvchiActivity::class.java))
            }
            xaridorTextView.setOnClickListener {
                startActivity(Intent(this@MainActivity, XaridorActivity::class.java))
            }
            buyurtmaTextView.setOnClickListener {
                startActivity(Intent(this@MainActivity, BuyurtmaActivity::class.java))
            }
        }

    }
}