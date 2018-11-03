package com.kotlearn.kotlearn

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView

class ActivityChoosePokemon : AppCompatActivity() {

    lateinit var inputStr: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose_pokemon)

        var inputName = findViewById<EditText>(R.id.input_name)
        inputName.setText("0")

        val submit = findViewById<Button>(R.id.btn_submit)
        submit.setOnClickListener {
            inputStr = inputName.text.toString()
            val welcomeImg = findViewById<ImageView>(R.id.welcome_img)
            welcomeImg.visibility = View.GONE
        }
    }


}
