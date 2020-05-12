package com.example.ds_fitness

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.view.View
import android.widget.TextView

class LoginActivity : AppCompatActivity() {

    private lateinit var textLoginFailed: TextView
    private lateinit var enteredUsername: EditText
    private lateinit var enteredPassword: EditText
    private lateinit var buttonLogin : Button
    private lateinit var buttonSignUp : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.setContentView(R.layout.login_layout)

        enteredUsername = findViewById(R.id.username_edit_text)
        enteredPassword = findViewById(R.id.password_edit_text)
        buttonLogin = findViewById(R.id.button_login)
        buttonSignUp = findViewById(R.id.button_sign_up)
        textLoginFailed = findViewById(R.id.login_failed_text)

        buttonLogin.setOnClickListener()
        {
            //Button click will call a separate validation method
            validateLoginAttempt(enteredUsername.text.toString(), enteredPassword.text.toString())
        }

    }

    private fun validateLoginAttempt(recUserName: String, recPassword: String)
    {
        if(Logic.validate(recUserName, recPassword))
        {
            //progress to the homepage
            val intent = Intent(this, homePage::class.java)
            intent.putExtra("ID_EXTRA", recUserName)
            startActivity(intent)
        }
        else
        {
            //Get interface to display message to user
            showFailedLoginState()
        }
    }

    private fun showFailedLoginState()
    {
        //Change the login page layout so that it tells the user that the previous login attempt
        // failed.
        showView(textLoginFailed as View)

    }

    //May be better if this was moved to the logic class
    private fun showView(view: View)
    {
        view.visibility = View.VISIBLE
    }

    private fun hideView(view: View)
    {
        view.visibility = View.GONE
    }

}
