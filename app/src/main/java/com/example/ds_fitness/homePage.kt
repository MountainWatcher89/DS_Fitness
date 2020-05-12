package com.example.ds_fitness

import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import java.util.logging.Logger

class homePage : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        try {
            setContentView(R.layout.homepage_layout)
        }
        catch (e: Exception)
        {
            Logger.getLogger(homePage::class.java.name).warning("An error occured while trying to create the activity: " + e.toString())
            throw e
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
            val intent = Intent(this, NutritionActivity::class.java)

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
    }

}