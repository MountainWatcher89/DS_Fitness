package com.example.ds_fitness

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import org.w3c.dom.Text

class LoginActivity : AppCompatActivity() {

    //Linear layouts
    private lateinit var myLoginLinearLayout: LinearLayout
    private lateinit var mySignUpLinearLayout: LinearLayout

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

        myLoginLinearLayout = findViewById(R.id.loginWidgetsLayout)
        mySignUpLinearLayout = findViewById(R.id.signUpWidgetsLayout)

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

        //Sign up button listener
        buttonSignUp.setOnClickListener()
        {
            //Deactivate and clear the login widgets
            Logic.disableEditText(enteredUsername)
            Logic.disableEditText(enteredPassword)

            Logic.disableButton(buttonLogin)
            Logic.disableButton(buttonSignUp)

            //Hide the login section
            myLoginLinearLayout.visibility = View.GONE

            //Show sign up section
            mySignUpLinearLayout.visibility = View.VISIBLE

            //Activate the sign up widgets
            Logic.enableEditText(enteredNewUsername)
            Logic.enableEditText(enteredNewEmail)
            Logic.enableEditText(enteredNewPassword)
            Logic.enableEditText(enteredNewConfirmedPassword)

            Logic.enableButton(buttonCancelSignUp)
            Logic.enableButton(buttonFinishSignUp)

        }

        //Login button listener
        buttonCancelSignUp.setOnClickListener()
        {
            //Deactivate and clear the sign up widgets
            Logic.disableEditText(enteredNewUsername)
            Logic.disableEditText(enteredNewEmail)
            Logic.disableEditText(enteredNewPassword)
            Logic.disableEditText(enteredNewConfirmedPassword)

            Logic.disableButton(buttonCancelSignUp)
            Logic.disableButton(buttonFinishSignUp)

            //Hide the sign up section
            mySignUpLinearLayout.visibility = View.GONE

            //Show login section
            myLoginLinearLayout.visibility = View.VISIBLE

            //Show and activate the login widgets
            Logic.enableEditText(enteredUsername)
            Logic.enableEditText(enteredPassword)

            Logic.enableButton(buttonLogin)
            Logic.enableButton(buttonSignUp)
        }

        //Sign up button listener
        buttonFinishSignUp.setOnClickListener()
        {
            if(tryToCreateAccount(enteredNewUsername.text.toString(),
                enteredNewEmail.text.toString(),
                enteredNewPassword.text.toString(),
                enteredNewConfirmedPassword.text.toString()))
            {

            }
            else
            {
                //Change sign up widgets to explain reason for account creation failure

            }
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
        textLoginFailed.visibility = View.VISIBLE

    }

    fun tryToCreateAccount(recUserName: String, recEmail: String, recPassword: String, recConfirmPassword: String): Boolean
    {
        var retVal = false

        //Check for a valid username
        val usernameResult = Logic.validateUsername(recUserName)
        if(usernameResult.first)
        {
            retVal = true
        }
        else
        {
            //Display warning message
            textUsernameInvalid.text = usernameResult.second
            return false
        }

        //Check for a valid email address
        val emailResult = Logic.validateUsername(recEmail)
        if(emailResult.first)
        {
            retVal = true
        }
        else
        {
            //Display warning message
            textEmailInvalid.text = emailResult.second
            return false
        }

        //Check for a valid password
        val passwordResult = Logic.validatePassword(recPassword)
        if(passwordResult.first)
        {
            retVal = true
        }
        else
        {
            //Display warning message
            textNewPasswordInvalid.text = passwordResult.second
            return false
        }

        //Check for a valid confirmed password
        val confirmPasswordResult = Logic.validateConfirmPassword(recPassword, recConfirmPassword)
        if(confirmPasswordResult.first)
        {
            retVal = true
        }
        else
        {
            //Display warning message
            textNewConfirmedPasswordInvalid.text = confirmPasswordResult.second
            return false
        }
        return retVal
    }
}
