package com.example.ds_fitness

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

const val EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE"
class Nutrition : AppCompatActivity() {


    private lateinit var buttonGoToNextActivity: Button
    private lateinit var buttonGoToHomepage: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.nutrition_layout)

        buttonGoToNextActivity = findViewById(R.id.buttonSubmitText)
        buttonGoToHomepage = findViewById(R.id.buttonBackToHomepage)

        buttonGoToNextActivity.setOnClickListener()
        {
            sendMessage()
        }

        buttonGoToHomepage.setOnClickListener()
        {
            val intent = Intent(this, Homepage::class.java)
            startActivity(intent)
        }
    }

    fun sendMessage() {
        val editText = findViewById<EditText>(R.id.someText_edit_text)
        val message = editText.text.toString()
        val intent = Intent(this, NutritionInfo::class.java).apply {
            putExtra(EXTRA_MESSAGE, message)
        }
        startActivity(intent)
    }
}
