package com.codewithsouma.foodrunner.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.widget.Toolbar
import com.codewithsouma.foodrunner.R

class RegisterActivity : AppCompatActivity(), OnClickListener {
    private lateinit var toolbar: Toolbar
    private lateinit var etName: EditText
    private lateinit var etEmailAddress: EditText
    private lateinit var etMobileNumber: EditText
    private lateinit var etDeliveryAddress: EditText
    private lateinit var etPassword: EditText
    private lateinit var etConfirmPassword: EditText
    private lateinit var  btnRegister: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        toolbar = findViewById(R.id.toolbar)
        etName = findViewById(R.id.etName)
        etEmailAddress = findViewById(R.id.etEmailAddress)
        etMobileNumber = findViewById(R.id.etMobileNumber)
        etDeliveryAddress = findViewById(R.id.etDeliveryAddress)
        etPassword = findViewById(R.id.etPassword)
        etConfirmPassword = findViewById(R.id.etConfirmPassword)
        btnRegister = findViewById(R.id.btnRegister)

        btnRegister.setOnClickListener(this)

        setUpToolBar()
    }

    private fun setUpToolBar() {
        setSupportActionBar(toolbar)
        title = "Register yourself"
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val itemId = item.itemId
        if (itemId == android.R.id.home){
            this.finish()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onClick(view: View?) {

    }
}