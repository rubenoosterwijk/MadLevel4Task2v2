package com.example.madlevel4task2v2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.navigation.NavController
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        navController = findNavController(R.id.nav_host_fragment)
        navController.addOnDestinationChangedListener { _, _, _ ->
            DisplayBackButton()
        }
        toolbar.setNavigationOnClickListener {
            if (navController.previousBackStackEntry != null) navController.popBackStack()
        }
    }

    private fun DisplayBackButton() {
        supportActionBar?.setDisplayHomeAsUpEnabled(navController.previousBackStackEntry!= null)
    }
}