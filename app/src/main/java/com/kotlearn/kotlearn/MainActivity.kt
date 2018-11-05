package com.kotlearn.kotlearn

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var topicDbHelper: DBHelper

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        var selectedFragment: android.support.v4.app.Fragment? = null
        when (item.itemId) {
            R.id.navigation_profile -> {
                selectedFragment = ProfileFragment()
            }
            R.id.navigation_content -> {
                selectedFragment = ContentFragment()
            }
            R.id.navigation_complier -> {
                selectedFragment = CompilerFragment()
            }
        }
        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, selectedFragment)
        transaction.commit()
        return@OnNavigationItemSelectedListener true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, ProfileFragment()).commit()

        topicDbHelper = DBHelper(this)

        var allTopics = topicDbHelper.readAllTopics()

        println("TEST " + allTopics.size)
        if (allTopics.isEmpty()) {
            println("NO TOPICS " + allTopics.size)
            InternetJSON(this@MainActivity,"http://172.19.195.190:8080/KotlearnBackend-war/resources/topics/getTopics",
                    topicDbHelper).execute()
        }
    }
}
