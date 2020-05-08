package com.example.ds_fitness

import java.math.BigInteger
import java.security.MessageDigest

class logic
{
    fun validate(recUsername:  String, recPassword: String): Boolean
    {
        var retVal = false

        //Temporary username and password check. This should be replaced with encrypting the given
        //password, to check if the produced hash matches the hash of the user's current password.
        if(recUsername === "admin" && recPassword === "admin")
        {
            retVal = true
        }

        //val passwordInput
        //val hashedPasswordInput = passwordInput.sha256()

        return retVal
    }

    fun String.sha256(): String {
        val md = MessageDigest.getInstance("SHA-256")
        return BigInteger(1, md.digest(toByteArray())).toString(16).padStart(32, '0')
    }
}