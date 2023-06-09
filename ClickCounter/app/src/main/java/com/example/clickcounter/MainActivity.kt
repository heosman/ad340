package com.example.clickcounter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val increment = findViewById<Button>(R.id.increment)
        increment.text = "Increment"
        val decrement = findViewById<Button>(R.id.decrement)
        decrement.text = "Decrement"
        val reset = findViewById<Button>(R.id.reset)
        reset.text = "Reset"

        val counter: TextView = findViewById(R.id.textView)
        var count = 0
        counter.text = count.toString()

        val duration = Toast.LENGTH_SHORT
        increment.setOnClickListener {
            Toast.makeText(applicationContext, "Increment: " + count.toString() + " -> " + (count + 1).toString(), duration).show()
            count += 1
            counter.text = count.toString()
        }

        decrement.setOnClickListener {
            Toast.makeText(applicationContext, "Decrement: " + count.toString() + " -> " + (count - 1).toString(), duration).show()
            count -= 1
            counter.text = count.toString()
        }

        reset.setOnClickListener {
            Toast.makeText(applicationContext, "Reset: $count -> 0", duration).show()
            count = 0
            counter.text = count.toString()
        }

    }
}