package com.example.ds_fitness

import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import java.util.logging.Logger

class Homepage : AppCompatActivity(){

    private lateinit var textUsername: TextView
    private lateinit var buttonSignOut: Button

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)

        try {
            setContentView(R.layout.homepage_layout)
        }
        catch (e: Exception)
        {
            Logger.getLogger(Homepage::class.java.name).warning("An error occured while trying to create the activity: " + e.toString())
            throw e
        }

        buttonSignOut = findViewById(R.id.buttonSignOut)

        if(intent.getStringExtra("ID_EXTRA") != null)
        {
            textUsername = findViewById(R.id.textUsername)
            textUsername.text = intent.getStringExtra("ID_EXTRA")
        }

        val bmiBtn = findViewById<LinearLayout>(R.id.bmiCalculator)
        val nutritionBtn = findViewById<LinearLayout>(R.id.nutritionPlans)
        val workoutBtn = findViewById<LinearLayout>(R.id.workoutPlans)
        val activityTrackingBtn = findViewById<LinearLayout>(R.id.activityTracking)

        bmiBtn.setOnClickListener {
            val intent = Intent(this, BMIActivity::class.java)

            startActivity(intent)
        }

        nutritionBtn.setOnClickListener {
            val intent = Intent(this, NutritionStart::class.java)

            startActivity(intent)
        }

        workoutBtn.setOnClickListener {
            val intent = Intent(this, WorkoutActivity::class.java)

            startActivity(intent)
        }

        activityTrackingBtn.setOnClickListener {
            val intent = Intent(this, TrackingActivity::class.java)

            startActivity(intent)
        }


        buttonSignOut.setOnClickListener()
        {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

    }

}