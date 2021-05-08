package com.codewithsouma.foodrunner.activity

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import com.codewithsouma.foodrunner.R

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
        WindowManager.LayoutParams.FLAG_FULLSCREEN)

        Handler().postDelayed({
            var intent = Intent(this, LoginActivity::class.java)
            val sharedPreferences: SharedPreferences? = getSharedPreferences(getString(R.string.loginPreferences), MODE_PRIVATE)
            if (sharedPreferences != null){
                val isLoggedIn = sharedPreferences.getBoolean(getString(R.string.isLoggedIn),false)
                if (isLoggedIn){
                    intent = Intent(this, MainActivity::class.java)
                }
            }
            startActivity(intent)
            this.finish()
        },3000)
    }
}