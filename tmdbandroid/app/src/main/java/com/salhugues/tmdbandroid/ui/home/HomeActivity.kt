package com.salhugues.tmdbandroid.ui.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.salhugues.tmdbandroid.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }
}
