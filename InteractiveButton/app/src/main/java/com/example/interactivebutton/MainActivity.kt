package com.example.interactivebutton

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.interactivebutton.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(
            this, R.layout.activity_main)

        val text = "Here is a toast!"
        val duration = Toast.LENGTH_SHORT

        binding.name = "Button"
        binding.button2.setOnClickListener {
            Toast.makeText(applicationContext, text, duration).show()
        }
    }
}
