package com.kotlearn.kotlearn

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.*
import android.webkit.WebView
import android.webkit.WebViewClient





class ProfileFragment : android.support.v4.app.Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    lateinit var sharedPreferences: SharedPreferences
    private var myPreferences = "myPrefs"
    private var URL = "URL"
    private var empty = ""

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val context = this@ProfileFragment.activity!!.applicationContext
        val webView = view.findViewById<WebView>(R.id.web_view)
        sharedPreferences = context.getSharedPreferences(myPreferences, Context.MODE_PRIVATE)
        if (sharedPreferences.getString(URL, empty) != empty) {
            webView.loadUrl(sharedPreferences.getString(URL, empty))
        } else {
            webView.loadUrl("https://www.google.com.sg")
        }
        webView.setOnKeyListener(View.OnKeyListener { _, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_BACK && event.action == MotionEvent.ACTION_UP && webView.canGoBack()) {
                webView.goBack()
                return@OnKeyListener true
            }
            false
        })
        val webSettings = webView.getSettings()
        webSettings.setJavaScriptEnabled(true)
        webView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
                val editor = sharedPreferences.edit()
                editor.putString(URL, url)
                editor.apply()
                return false
            }
        }
    }
}