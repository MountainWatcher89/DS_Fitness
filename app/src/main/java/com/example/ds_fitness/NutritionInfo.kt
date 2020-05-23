package com.example.ds_fitness

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class NutritionInfo : AppCompatActivity() {

    private lateinit var textReceivedText: TextView
    private lateinit var buttonGoToHomepage: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.nutrition_info_layout)

        textReceivedText = findViewById(R.id.textViewDisplayReceivedText)
        buttonGoToHomepage = findViewById(R.id.buttonBackToHomepageB)
        // Get the Intent that started this activity and extract the string
        val message = intent.getStringExtra(EXTRA_MESSAGE)

        // Capture the layout's TextView and set the string as its text
        val textView = findViewById<TextView>(R.id.textView).apply {
            text = message
        }

        buttonGoToHomepage.setOnClickListener()
        {
            val intent = Intent(this, Homepage::class.java)
            startActivity(intent)
        }

    }
}
