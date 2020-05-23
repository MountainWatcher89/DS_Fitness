package com.example.ds_fitness

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

const val EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE"
class NutritionStart : AppCompatActivity() {


    private lateinit var buttonGoToNextActivity: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.nutrition_layout)


        buttonGoToNextActivity.setOnClickListener()
        {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
    fun sendMessage(view: View) {
        //val editText = findViewById<EditText>(R.id.editText)
        //val message = editText.text.toString()
        //val intent = Intent(this, Nutrition::class.java).apply {
        //    putExtra(EXTRA_MESSAGE, message)
        //}
        //startActivity(intent)

    }
}
