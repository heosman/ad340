package com.example.firstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button)

        val text = "Here is a toast!"
        val duration = Toast.LENGTH_SHORT

        button.setOnClickListener() {
            Toast.makeText(applicationContext, text, duration).show()
        }
    }
}