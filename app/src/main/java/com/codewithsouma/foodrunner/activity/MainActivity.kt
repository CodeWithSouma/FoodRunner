package com.codewithsouma.foodrunner.activity

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.FrameLayout
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.codewithsouma.foodrunner.R
import com.codewithsouma.foodrunner.fragment.*
import com.google.android.material.navigation.NavigationView
import com.google.android.material.navigation.NavigationView.OnNavigationItemSelectedListener

class MainActivity : AppCompatActivity(), OnNavigationItemSelectedListener {
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var coordinatorLayout: CoordinatorLayout
    private lateinit var toolbar: Toolbar
    private lateinit var navigationView: NavigationView
    private lateinit var frameLayout: FrameLayout

    private var previousMenuItem: MenuItem? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawerLayout = findViewById(R.id.drawerLayout)
        coordinatorLayout = findViewById(R.id.coordinatorLayout)
        toolbar = findViewById(R.id.toolbar)
        navigationView = findViewById(R.id.navigationView)
        frameLayout = findViewById(R.id.frameLayout)

        setUpToolbar()
        loadFragment("All Restaurants", DashboardFragment())
        setAppBarTitle("All Restaurants")

        val actionBarDrawerToggle =
            ActionBarDrawerToggle(this, drawerLayout, R.string.open_drawer, R.string.close_drawer)
        drawerLayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()

        navigationView.setNavigationItemSelectedListener(this)
    }

    private fun setUpToolbar() {
        setSupportActionBar(toolbar)
        title = "All Restaurants"
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        if (previousMenuItem != null)
            previousMenuItem?.isChecked = false

        item.isCheckable = true
        item.isChecked = true
        previousMenuItem = item

        when (item.itemId) {
            R.id.home -> {
                drawerLayout.closeDrawers()
                loadFragment("All Restaurants", DashboardFragment())
            }
            R.id.myProfile -> {
                drawerLayout.closeDrawers()
                loadFragment("My Profile", ProfileFragment())
            }
            R.id.favoriteRestaurants -> {
                drawerLayout.closeDrawers()
                loadFragment("Favourite Restaurants", FavoriteRastaurantFragment())
            }
            R.id.orderHistory -> {
                drawerLayout.closeDrawers()
                loadFragment("Order History", OrderHistoryFragment())
            }
            R.id.faq -> {
                drawerLayout.closeDrawers()
                loadFragment("FAQs", FaqFragment())
            }
            R.id.logOut -> {
                savePreferences(false)
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                this.finish()
            }
        }
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == android.R.id.home) {
            drawerLayout.openDrawer(GravityCompat.START)
        }

        return super.onOptionsItemSelected(item)
    }


    private fun loadFragment(title: String, fragment: Fragment) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(frameLayout.id, fragment)
        fragmentTransaction.commit()

        setAppBarTitle(title)
    }

    private fun setAppBarTitle(title: String) {
        supportActionBar?.title = title
    }

    private fun savePreferences(value: Boolean) {
        val preferences = getSharedPreferences(getString(R.string.loginPreferences), MODE_PRIVATE)
        val editor = preferences.edit()
        editor.putBoolean(getString(R.string.isLoggedIn), value)
        editor.apply()
    }

    override fun onBackPressed() {
        when (supportFragmentManager.findFragmentById(frameLayout.id)) {
            !is DashboardFragment -> {
                loadFragment("All Restaurants", DashboardFragment())
            }
            else -> super.onBackPressed()
        }
    }
}