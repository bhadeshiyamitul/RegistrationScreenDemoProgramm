package com.ubrain.registrationscreendemoproject

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_registration.*
import java.util.regex.Matcher
import java.util.regex.Pattern

class RegistrationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        btnRegistration!!.setOnClickListener {
            if (etFullName.text.trim().isNotEmpty() && etEmail.text.trim().isNotEmpty() &&
                    etPassword.text.trim().isNotEmpty() && etConfirmPassword.text.trim().isNotEmpty()) {
                if (isEmailValid(this, etEmail)) {
                    if (isValidPassword(this, etPassword)) {
                        if (etPassword.text.trim().toString() == etConfirmPassword.text.trim().toString()) {
                            //startActivity(Intent(this, SmallProgramsActivity::class.java))
                            Toast.makeText(applicationContext, "valid all details", Toast.LENGTH_SHORT).show()

                        } else {
                            Toast.makeText(this, "Enter proper confirm password", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            } else {
                Toast.makeText(this, "Enter all details", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun isEmailValid(context: Context, edittextSignupName: EditText): Boolean {
        val expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$"
        val pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE)
        val matcher = pattern.matcher(edittextSignupName.text.toString().trim())
        //return matcher.matches();
        return if (matcher.matches()) {
            true
        } else {
            Toast.makeText(context, "Please enter valid email", Toast.LENGTH_SHORT).show()
            false
        }
    }

    private fun isValidPassword(context: Context, edittextSignupName: EditText): Boolean {
        val pattern: Pattern
        val matcher: Matcher
        // val PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{4,9}$"
        val passwordPattern = "[a-zA-Z0-9*&%$#]{4,9}"
        pattern = Pattern.compile(passwordPattern)
        matcher = pattern.matcher(edittextSignupName.text.toString().trim())
        return if (matcher.matches()) {
            true
        } else {
            Toast.makeText(context, "Please enter valid password", Toast.LENGTH_SHORT).show()
            false
        }

    }
}
