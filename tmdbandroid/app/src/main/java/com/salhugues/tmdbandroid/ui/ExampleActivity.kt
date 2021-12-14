package com.salhugues.tmdbandroid.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.salhugues.tmdbandroid.databinding.ActivityExampleBinding
import timber.log.Timber

private const val TAG = "EXAMPLE"

class ExampleActivity : AppCompatActivity() {

    private lateinit var binding: ActivityExampleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.d("$TAG Activity Lifecycle: OnCreate()")
        binding = ActivityExampleBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onStart() {
        super.onStart()
        Timber.d("$TAG Activity Lifecycle: OnStart()")
    }

    override fun onResume() {
        super.onResume()
        Timber.d("$TAG Activity Lifecycle: OnResume()")
    }

    override fun onPause() {
        super.onPause()
        Timber.d("$TAG Activity Lifecycle: OnPause()")
    }

    override fun onStop() {
        super.onStop()
        Timber.d("$TAG Activity Lifecycle: OnStop()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Timber.i("$TAG Activity Lifecycle: OnDestroy()")
    }
}
