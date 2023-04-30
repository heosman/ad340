package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val food = findViewById<Button>(R.id.food)
        food.text = "Food"
        val touch = findViewById<Button>(R.id.touch)
        touch.text = "Touch"

        val image = findViewById<ImageView>(R.id.image)
        image.setBackgroundResource(R.drawable.blank)

        val duration = Toast.LENGTH_SHORT

        food.setOnClickListener {
            image.setBackgroundResource(R.drawable.image_3)
            Toast.makeText(applicationContext, "Shiba Inu is calm!", duration).show()
        }

        touch.setOnClickListener {
            image.setBackgroundResource(R.drawable.angry_shiba)
            Toast.makeText(applicationContext, "Shiba Inu is angry!", duration).show()
        }

    }
}