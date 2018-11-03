package com.kotlearn.kotlearn

import android.app.Fragment
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        var selectedFragment: android.support.v4.app.Fragment? = null
        when (item.itemId) {
            R.id.navigation_profile -> {
//                message.setText("helo")
                selectedFragment = ProfileFragment()
//                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_content -> {
//                message.setText("Content")
                selectedFragment = ContentFragment()
//                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_complier -> {
//                message.setText("Complier")
                selectedFragment = CompilerFragment()
//                return@OnNavigationItemSelectedListener true
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
    }
}
