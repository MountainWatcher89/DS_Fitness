package com.example.ds_fitness

import android.widget.Button
import android.widget.EditText
import java.math.BigInteger
import java.security.MessageDigest

class Logic
{
    companion object
    {

        val lowerCaseLetters = listOf<String>("a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z")
        val upperCaseLetters = listOf<String>("A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z")
        val numbers = listOf<String>("0","1","2","3","4","5","6","7","8","9")
        val symbols = listOf<String>("`", "¬", "!", "\"", "£","$","€","%","^","&","*","(",")","-","_","=","+","[","{","]","}",";",":","'","@","#","~","\\","|",",","<",".",">","/","?"," ")

        fun validate(recUsername:  String, recPassword: String): Boolean
        {
            var retVal = false

            //Temporary username and password check. This should be replaced with encrypting the given
            //password, to check if the produced hash matches the hash of the user's current password.
            if(recUsername == "admin" && recPassword == "admin")
            {
                retVal = true
            }

            //val passwordInput
            //val hashedPasswordInput = passwordInput.sha256()

            return retVal
        }

        fun enableEditText(editText: EditText)
        {
            editText.isClickable = true
        }

        fun disableEditText(editText: EditText)
        {
            editText.text = null
            editText.isClickable = false
        }

        fun enableButton(button: Button)
        {
            button.isClickable = true
        }

        fun disableButton(button: Button)
        {
            button.isClickable = false
        }

        fun String.sha256(): String {
            val md = MessageDigest.getInstance("SHA-256")
            return BigInteger(1, md.digest(toByteArray())).toString(16).padStart(32, '0')
        }


        fun validateUsername(recUsername: String): Pair<Boolean, String>
        {
            if(checkUsernames(recUsername)){
                return Pair(true, "")
            }
            else
            {
                return Pair(false, "Entered username is already in use")
            }
        }

        fun validateEmail(recEmail: String): Pair<Boolean, String>
        {
            if(checkEmails(recEmail)){
                return Pair(true, "")
            }
            else
            {
                return Pair(false, "Entered email address is already in use")
            }
        }

        //Function that checks for validity and strength of given password
        fun validatePassword(recPassword: String): Pair<Boolean, String>
        {
            //Check for minimum password length of 8 characters
            if(recPassword.length < 8)
            {
                return Pair(false, "Minimum password length is 8 characters")
            }

            //Check for maximum password length of 20 characters
            if(recPassword.length > 20)
            {
                return Pair(false, "Maximum password length is 20 characters")
            }

            //Check for lower case letter
            for(letter in lowerCaseLetters)
            {
                if(recPassword.contains(letter))
                {
                    break
                }
                if(letter == lowerCaseLetters.last())
                {
                    return Pair(false, "Password must contain at least one lower case letter")
                }
            }

            //Check for upper case letter
            for(letter in upperCaseLetters)
            {
                if(recPassword.contains(letter))
                {
                    break
                }
                if(letter == upperCaseLetters.last())
                {
                    return Pair(false, "Password must contain at least one upper case letter")
                }
            }

            //Check for number
            for(number in numbers)
            {
                if(recPassword.contains(number))
                {
                    break
                }
                if(number == numbers.last())
                {
                    return Pair(false, "Password must contain at least one number")
                }
            }

            //Check for symbol
            for(symbol in symbols)
            {
                if(recPassword.contains(symbol))
                {
                    break
                }
                if(symbol == symbols.last())
                {
                    return Pair(false, "Password must contain at least one symbol")
                }
            }
            //If all of these checks pass, then the password is valid
            return Pair(true, "")
        }

        //Function that checks if the confirmed password matches the first password
        fun validateConfirmPassword(recPassword: String, recConfirmPassword: String): Pair<Boolean, String>
        {
            if(recConfirmPassword == recPassword)
            {
                return Pair(true, "")
            }
            else
            {
                return Pair(false, "Confirmed password does not match password")
            }
        }

        fun checkUsernames(recUsername: String): Boolean
        {
            //Real implementation would connect to database and check for any duplicate usernames
            if(recUsername == "admin")
            {
                return false
            }
            return true
        }

        fun checkEmails(recUsername: String): Boolean
        {
            //Real implementation would connect to database and check for any duplicate email addresses
            return true
        }

        //This function is called when a user creates a valid account
        //This function would then communicate with a database to add the new  user account
        fun createUserAccount()
        {


        }
    }

}