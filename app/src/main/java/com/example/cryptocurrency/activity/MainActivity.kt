package com.example.cryptocurrency.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.ui.NavigationUI
import com.example.cryptocurrency.R
import com.example.cryptocurrency.utils.setupWithNavController
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var currentNavController: LiveData<NavController>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        cryptocurrencyBottomNavigation.itemIconTintList = null
        setSupportActionBar(toolbar)
        toolbar.setTitleTextColor(ContextCompat.getColor(baseContext, android.R.color.black))
        setupBottomNavigationBar()
    }

    private fun setupBottomNavigationBar() {
        val navGraphIds = listOf(
            R.navigation.cryptocurrency_list_graph,
            R.navigation.currency_converter_graph
        )
        val controller = cryptocurrencyBottomNavigation.setupWithNavController(
            navGraphIds = navGraphIds,
            fragmentManager = supportFragmentManager,
            containerId = R.id.cryptocurrencyNavHostFragment,
            intent = intent
        )
        controller.observe(this, Observer { navController ->
            NavigationUI.setupActionBarWithNavController(this, navController)
        })
        currentNavController = controller
    }

    override fun onSupportNavigateUp() = currentNavController?.value?.navigateUp() ?: false

}