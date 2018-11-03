package com.kotlearn.kotlearn

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn  = findViewById<Button>(R.id.button)
        btn.setOnClickListener{
            val myIntent = Intent(this, ActivityLesson::class.java)
            startActivity(myIntent)
        }
    }
}
