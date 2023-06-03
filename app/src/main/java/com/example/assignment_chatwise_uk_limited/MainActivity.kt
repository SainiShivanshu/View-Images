package com.example.assignment_chatwise_uk_limited

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.assignment_chatwise_uk_limited.activity.Show_Images
import com.example.assignment_chatwise_uk_limited.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var  binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
setContentView(binding.root)
        supportActionBar?.title="Images"
        binding.viewImages.setOnClickListener {
            startActivity(Intent(this,Show_Images::class.java))
        }
    }
}