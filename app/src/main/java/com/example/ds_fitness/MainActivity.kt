package com.example.ds_fitness

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    private var myloginView: loginView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        myloginView = loginView(this)
        setContentView(myloginView)
    }
}
