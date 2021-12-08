package com.salhugues.tmdbandroid.ui.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import com.salhugues.tmdbandroid.databinding.ActivityHomeBinding
import timber.log.Timber

private const val TAG = "HOME"

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private lateinit var homeNavController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.d("$TAG Activity Lifecycle: OnCreate()")

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        homeNavController = (
            supportFragmentManager.findFragmentById(binding.homeNavHost.id)
                as NavHostFragment
            ).navController

        setupActionBarWithNavController(homeNavController)
    }

    override fun onSupportNavigateUp(): Boolean {
        return homeNavController.navigateUp() || super.onSupportNavigateUp()
    }

    override fun onStart() {
        Timber.d("$TAG Activity Lifecycle: OnStart()")
        super.onStart()
    }

    override fun onResume() {
        Timber.d("$TAG Activity Lifecycle: OnResume()")
        super.onResume()
    }

    override fun onPause() {
        Timber.d("$TAG Activity Lifecycle: OnPause()")
        super.onPause()
    }

    override fun onStop() {
        Timber.d("$TAG Activity Lifecycle: OnStop()")
        super.onStop()
    }

    override fun onDestroy() {
        Timber.d("$TAG Activity Lifecycle: OnDestroy()")
        super.onDestroy()
    }
}
