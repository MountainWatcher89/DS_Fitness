package com.example.ds_fitness

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class loginActivity : AppCompatActivity() {

    private lateinit var enteredUsername: EditText
    private lateinit var enteredPassword: EditText
    private lateinit var buttonLogin : Button
    private lateinit var buttonSignUp : Button

    private lateinit var myLogicInstance: logic

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.setContentView(R.layout.activity_main)

        enteredUsername = findViewById(R.id.username_edit_text)
        enteredPassword = findViewById(R.id.password_edit_text)
        buttonLogin = findViewById(R.id.button_login)
        buttonSignUp = findViewById(R.id.button_sign_up)

        buttonLogin.setOnClickListener()
        {
            //Button click will call a separate validation method
            validateLoginAttempt(enteredUsername.text.toString(), enteredPassword.text.toString())
        }

    }

    private fun validateLoginAttempt(recUserName: String, recPassword: String)
    {
        if(myLogicInstance.validate(recUserName, recPassword))
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

    private  fun showFailedLoginState()
    {
        //Change the login page layout so that it tells the user that the previous login attempt
        // failed.


    }

}
