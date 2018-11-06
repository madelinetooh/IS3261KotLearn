package com.kotlearn.kotlearn

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.text.Editable
import android.text.Html
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import kotlinx.android.synthetic.main.fragment_compiler.*
import kotlinx.android.synthetic.main.fragment_compiler.view.*

class CompilerFragment : android.support.v4.app.Fragment() {
    lateinit var contentString: String
    lateinit var sharedPreferences: SharedPreferences
    private var myPreferences = "myPrefs"
    private var CODE = "code"
    private var empty = ""

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        contentString = if (arguments != null) arguments!!.getString("code") else ""

        val view: View = inflater.inflate(R.layout.fragment_compiler, container, false)

        val input = view.code_editor

        input.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                var lines = code_editor.lineCount
                var linestext: String = ""
                for (i in 1..lines) {
                    linestext = linestext + i + "\n"

                }
                lineCount.setText(linestext)
            }

        })

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val context = this@CompilerFragment.activity!!.applicationContext
        sharedPreferences = context.getSharedPreferences(myPreferences, Context.MODE_PRIVATE)
        val codeEditor = view.findViewById<EditText>(R.id.code_editor)
        if (sharedPreferences.getString(CODE, empty) != empty) {
            codeEditor.setText(Html.fromHtml(sharedPreferences.getString(CODE, empty)))
        }
        codeEditor.setOnFocusChangeListener { v, hasFocus ->
            run {
                val editor = sharedPreferences.edit()
                editor.putString(CODE, Html.toHtml(codeEditor.text))
                editor.apply()
            }
        }
    }
}