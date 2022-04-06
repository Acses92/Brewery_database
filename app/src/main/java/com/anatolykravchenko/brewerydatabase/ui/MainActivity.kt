package com.anatolykravchenko.brewerydatabase.ui

import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import com.anatolykravchenko.brewerydatabase.R
import com.anatolykravchenko.brewerydatabase.databinding.ActivityMainBinding
import com.anatolykravchenko.brewerydatabase.ui.list.ListFragment
import com.anatolykravchenko.brewerydatabase.ui.search.SearchFragment
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var listFragment: ListFragment
    private lateinit var searchFragment: SearchFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        actionBarSetup()
        navigationViewSetup()
        homeFragmentSetup()
    }

    private fun homeFragmentSetup() {
        //Настраиваем стартовый фрагмент
        listFragment = ListFragment()
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.nav_host_fragment_content_main, listFragment, "LIST_FRAGMENT")
            .commit()
    }

    private fun actionBarSetup() {
        //Настраиваем actionBar
        setSupportActionBar(binding.appBarMain.toolbar)
        val toggle = ActionBarDrawerToggle(this, binding.drawerLayout, 0, 0 )
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
    }

    private fun navigationViewSetup() {
        //обрабатываем NavigationView
        binding.navView.setNavigationItemSelectedListener { menuItem ->
            menuItem.isChecked = false
            binding.drawerLayout.closeDrawers()
            when(menuItem.itemId) {
                R.id.nav_list -> {
                    listFragment = ListFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.nav_host_fragment_content_main, listFragment,
                            "LIST_FRAGMENT")
                        .addToBackStack(null)
                        .commit()
                }
                R.id.nav_search -> {
                    searchFragment = SearchFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.nav_host_fragment_content_main, searchFragment,
                            "SEARCH_FRAGMENT")
                        .addToBackStack(null)
                        .commit()
                }
            }
            true
        }
    }
}