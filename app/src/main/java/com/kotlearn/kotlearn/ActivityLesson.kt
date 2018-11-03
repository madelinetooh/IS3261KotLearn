package com.kotlearn.kotlearn

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ImageView

class ActivityLesson : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lesson)

        val typesImg = findViewById<ImageView>(R.id.types_img)
        typesImg.setOnClickListener{
            val myIntent = Intent(this, ActivityChoosePokemon::class.java)
            startActivity(myIntent)
        }

        val strImg = findViewById<ImageView>(R.id.string_img)
        strImg.setOnClickListener{
            val myIntent = Intent(this, ActivityString::class.java)
            startActivity(myIntent)
        }

        val arrayImg = findViewById<ImageView>(R.id.array_img)
        arrayImg.setOnClickListener{
            val myIntent = Intent(this, ActivityArray::class.java)
            startActivity(myIntent)
        }

        val loopImg = findViewById<ImageView>(R.id.loop_img)
        loopImg.setOnClickListener{
            val myIntent = Intent(this, ActivityLoop::class.java)
            startActivity(myIntent)
        }

        val funImg = findViewById<ImageView>(R.id.fun_img)
        funImg.setOnClickListener{
            val myIntent = Intent(this, ActivityFun::class.java)
            startActivity(myIntent)
        }
    }
}
