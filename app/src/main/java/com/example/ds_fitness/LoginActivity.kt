package com.example.ds_fitness

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.view.View
import android.widget.TextView
import org.w3c.dom.Text

class LoginActivity : AppCompatActivity() {

    //Login widgets

    private lateinit var enteredUsername: EditText
    private lateinit var enteredPassword: EditText

    private lateinit var textLoginFailed: TextView

    private lateinit var buttonLogin : Button
    private lateinit var buttonSignUp : Button

    //Sign up widgets
    private lateinit var enteredNewUsername: EditText
    private lateinit var enteredNewEmail : EditText
    private lateinit var enteredNewPassword: EditText
    private lateinit var enteredNewConfirmedPassword: EditText

    private lateinit var textUsernameInvalid: TextView
    private lateinit var textEmailInvalid: TextView
    private lateinit var textNewPasswordInvalid: TextView
    private lateinit var textNewConfirmedPasswordInvalid: TextView
    private lateinit var textSignUpFailed: TextView

    private lateinit var buttonCancelSignUp: Button
    private lateinit var buttonFinishSignUp: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.setContentView(R.layout.login_layout)

        enteredUsername = findViewById(R.id.username_edit_text)
        enteredPassword = findViewById(R.id.password_edit_text)
        enteredNewUsername = findViewById(R.id.newUsername_edit_text)
        enteredNewEmail = findViewById(R.id.email_edit_text)
        enteredNewPassword = findViewById(R.id.newPassword_edit_text)
        enteredNewConfirmedPassword = findViewById(R.id.newConfirmPassword_edit_text)

        textLoginFailed = findViewById(R.id.login_failed_text)
        textUsernameInvalid = findViewById(R.id.username_invalid_text)
        textEmailInvalid = findViewById(R.id.email_invalid_text)
        textNewPasswordInvalid = findViewById(R.id.new_password_invalid_text)
        textNewConfirmedPasswordInvalid = findViewById(R.id.newConfirmPassword_edit_text)
        textSignUpFailed = findViewById(R.id.signUp_failed_text)

        buttonLogin = findViewById(R.id.button_login)
        buttonSignUp = findViewById(R.id.button_sign_up)
        buttonCancelSignUp = findViewById(R.id.button_cancel_signUp)
        buttonFinishSignUp = findViewById(R.id.button_confirm_sign_up)


        //Login button listener
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
