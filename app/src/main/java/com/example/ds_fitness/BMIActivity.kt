package com.example.ds_fitness

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.bmi_layout.*

class BMIActivity : AppCompatActivity() {

    private lateinit var buttonCalculateBMI: Button
    private lateinit var buttonGoToHomepage: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.bmi_layout)

        buttonCalculateBMI = findViewById(R.id.btnCalculateBMI)
        buttonGoToHomepage = findViewById(R.id.buttonBackToHomepageBMI)

        buttonCalculateBMI.setOnClickListener()
        {
            calculateBMI()
        }

        buttonGoToHomepage.setOnClickListener()
        {
            val intent = Intent(this, Homepage::class.java)
            startActivity(intent)
        }


    }

    fun calculateBMI()
    {
        val h = (height.text).toString().toFloat() /100
        val w = weight.text.toString().toFloat()
        val res = w/(h*h)
        result.text = "%.2f".format(res)

        if (res < 18.5) {
            weight_class.text = "Underweight"
        } else if (res > 18.4 && res < 25) {
            weight_class.text = "Normal Weight"
        } else if (res > 24.9 && res < 30) {
            weight_class.text = "Overweight"
        } else {
            weight_class.text = "Obese"
        }
    }
}