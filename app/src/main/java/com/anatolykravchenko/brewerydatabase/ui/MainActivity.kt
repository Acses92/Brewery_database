package com.anatolykravchenko.brewerydatabase.ui

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.ActionBarDrawerToggle
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import com.anatolykravchenko.brewerydatabase.R
import com.anatolykravchenko.brewerydatabase.databinding.ActivityMainBinding
import com.anatolykravchenko.brewerydatabase.ui.list.ListFragment
import com.anatolykravchenko.brewerydatabase.ui.search.SearchFragment
import com.anatolykravchenko.brewerydatabase.ui.detail.BreweryDetailFragment



class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var listFragment: ListFragment
    private lateinit var searchFragment: SearchFragment
    private lateinit var breweryDetailFragment: BreweryDetailFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarMain.toolbar)
        val toggle = ActionBarDrawerToggle(this, binding.drawerLayout, 0, 0 )
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()


        listFragment = ListFragment()
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.nav_host_fragment_content_main, listFragment)
            .commit()

    }
}