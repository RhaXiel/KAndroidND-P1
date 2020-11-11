package com.udacity.shoestore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.databinding.ActivityMainBinding
import timber.log.Timber

class MainActivity : AppCompatActivity() {
    private lateinit var coordinatorLayout: CoordinatorLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Timber.plant(Timber.DebugTree())
        /*val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        coordinatorLayout = binding.coordinatorLayout
        val navController = this.findNavController(R.id.myNavHostFragment)*/
        //NavigationUI.setupActionBarWithNavController(this, navController, coordinatorLayout) //Original
        //NavigationUI.setupWithNavController(this, navController, coordinatorLayout)
        //appBarConfiguration = AppBarConfiguration(navController.graph, coordinatorLayout)
        // prevent nav gesture if not on start destination
        /*navController.addOnDestinationChangedListener { nc: NavController, nd: NavDestination, bundle: Bundle? ->
            if (nd.id == nc.graph.startDestination) {
                coordinatorLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED)
            } else {
                coordinatorLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)
            }
        }*/
        //NavigationUI.setupWithNavController(binding.navView, navController)
    }
}
