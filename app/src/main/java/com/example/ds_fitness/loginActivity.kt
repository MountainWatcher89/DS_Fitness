package com.example.ds_fitness

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class loginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.setContentView(R.layout.activity_main)
    }

    //Grey 160,160,160
    //Cyan 51.153.255

    //Set the color values
    private val myTopAndBottomBandsCol: Int = Color.rgb(51, 153, 255)
    private val myBackCol: Int = Color.rgb(160, 160, 160)
    private val myLoginBoxCol: Int = Color.rgb(224, 224, 224)
    private val myTextCol: Int = Color.WHITE

    //Set the paint variables
    private var myTopAndBottomBandsPaint: Paint
    private var myBackPaint: Paint
    private var myLoginBoxPaint: Paint
    private var myTextPaint: Paint

    //Set login screen widgets?
    //val myEditText = EditText


    init
    {
        //Paint objects

        myTopAndBottomBandsPaint = Paint().apply{
            style = Paint.Style.FILL
            color = myTopAndBottomBandsCol
        }

        myBackPaint = Paint().apply{
            style = Paint.Style.FILL
            color = myBackCol
        }

        myLoginBoxPaint = Paint().apply{
            style = Paint.Style.FILL
            color = myLoginBoxCol
        }

        myTextPaint = Paint().apply {
            textAlign = Paint.Align.CENTER
            textSize = 55f
            typeface = Typeface.SANS_SERIF
            color = myTextCol
        }
    }

    override fun onDraw(canvas: Canvas)
    {
        //super.onDraw(canvas)

        //val screenWidth = width.toFloat()
        //val screenHeight = height.toFloat()
        //val bannerHeight = screenHeight / 7

        //Rectangle parameters
        //left - The X coordinate of the left side of the rectangle
        //top - The Y coordinate of the top side of the rectangle
        //right - The X coordinate of the right side of the rectangle
        //bottom - The Y coordinate of the bottom side of the rectangle
        //paint - The paint object that will be used to display the rectangle

        //Draw background
        //canvas.drawRect(0f, 0f, screenWidth, screenHeight, myBackPaint)

        //Draw top and bottom rectangles
        //canvas.drawRect(0f, 0f, screenWidth, bannerHeight, myTopAndBottomBandsPaint)
        //canvas.drawRect(0f, screenHeight - bannerHeight, screenWidth, screenHeight, myTopAndBottomBandsPaint)

        //Draw login page title
        //canvas.drawText("DS Fitness", (screenWidth / 2), (bannerHeight / 2) + 20, myTextPaint)

        //Draw login rectangle
        //canvas.drawRect((screenWidth / 5), screenWidth * 2, screenWidth * 4, bannerHeight * 5, myLoginBoxPaint)


    }
}
