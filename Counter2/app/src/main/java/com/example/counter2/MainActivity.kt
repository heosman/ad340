package com.example.counter2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.counter2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(
            this, R.layout.activity_main)

        val counter: TextView = binding.textView
        var count = 0
        binding.name = count.toString()
        val duration = Toast.LENGTH_SHORT

        binding.increment = "Increment"
        binding.button.setOnClickListener {
            Toast.makeText(applicationContext, "Increment: " + count.toString() + " -> " + (count + 1).toString(), duration).show()
            count += 1
            counter.text = count.toString()
        }

        binding.decrement = "Decrement"
        binding.button2.setOnClickListener {
            Toast.makeText(applicationContext, "Decrement: " + count.toString() + " -> " + (count - 1).toString(), duration).show()
            count -= 1
            counter.text = count.toString()
        }

        binding.reset = "Reset"
        binding.button3.setOnClickListener {
            Toast.makeText(applicationContext, "Reset: $count -> 0", duration).show()
            count = 0
            counter.text = count.toString()
        }
    }
}