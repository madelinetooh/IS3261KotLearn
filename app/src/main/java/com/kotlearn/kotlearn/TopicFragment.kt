package com.kotlearn.kotlearn

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class TopicFragment : android.support.v4.app.Fragment() {
    lateinit var contentString: String

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        contentString = arguments!!.getString("content")
        return inflater.inflate(R.layout.fragment_topic, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val contentTextView = view.findViewById<TextView>(R.id.content_textview)
        contentTextView.text = contentString
    }
}