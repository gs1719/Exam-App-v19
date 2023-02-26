package com.example.v19

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.v19.databinding.ActivityResultBinding

class Result : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val Result = intent.getStringExtra(MainActivity.KEY)
        binding.textView.text = "You Received ${Result} OUT OF 4"

    }
}