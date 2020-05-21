package com.example.ds_fitness

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class TrackingActivity : AppCompatActivity() {

    private lateinit var buttonSignOut: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tracking_layout)

        buttonSignOut = findViewById(R.id.buttonSignOut)

        buttonSignOut.setOnClickListener()
        {
            val intent = Intent(this, Homepage::class.java)
            startActivity(intent)
        }

    }
}
