package com.codewithsouma.foodrunner.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.codewithsouma.foodrunner.R

class LoginActivity : AppCompatActivity(), OnClickListener {
    private lateinit var etMobileNumber: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnLogin: Button
    private lateinit var tvForgotPassword: TextView
    private lateinit var tvSignUp: TextView

    private val MOBILE_NUMBER = "8768454982"
    private val PASSWORD = "12345"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_login)

        etMobileNumber = findViewById(R.id.etMobileNumber)
        etPassword = findViewById(R.id.etPassword)
        btnLogin = findViewById(R.id.btnLogin)
        tvForgotPassword = findViewById(R.id.tvForgotPasswordLabel)
        tvSignUp = findViewById(R.id.tvSignUp)

        btnLogin.setOnClickListener(this)

    }

    override fun onClick(view: View?) {
        val mobileNumber = etMobileNumber.text.toString().trim()
        val password = etPassword.text.toString().trim()

        if (etMobileNumber.length() == 0)
            etMobileNumber.error = "Mobile number required"

        if (etPassword.length() == 0)
            etPassword.error = "Password required"

        if (formIsNotEmpty()) {
            if (validateLoginCredential(mobileNumber, password)) {
                savePreferences(true)

                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                this.finish()

            } else {

                etMobileNumber.text.clear()
                etPassword.text.clear()

                savePreferences(false)
                Toast.makeText(this, "Invalid credential", Toast.LENGTH_SHORT).show()
            }

        }
    }

    private fun formIsNotEmpty(): Boolean {
        return etMobileNumber.text.isNotEmpty() && etPassword.text.isNotEmpty()
    }

    private fun savePreferences(value: Boolean) {
        val preferences = getSharedPreferences(getString(R.string.loginPreferences), MODE_PRIVATE)
        val editor = preferences.edit()
        editor.putBoolean(getString(R.string.isLoggedIn), value)
        editor.apply()
    }

    private fun validateLoginCredential(
        mobileNumber: String,
        password: String
    ) = MOBILE_NUMBER == mobileNumber && PASSWORD == password

    fun startForgetPasswordActivity(view: View) {
        val intent = Intent(this, ForgotPasswordActivity::class.java)
        startActivity(intent)
    }
}