package com.kotlearn.kotlearn

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_compiler.*
import kotlinx.android.synthetic.main.fragment_compiler.view.*

class CompilerFragment : android.support.v4.app.Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view: View = inflater!!.inflate(R.layout.fragment_compiler, container, false)

        val input= view.inputCode

        input.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable?) {
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                var lines = inputCode.lineCount
                var linestext: String = ""
                for (i in 1..lines) {
                    linestext = linestext + i + "\n"

                }
                lineCount.setText(linestext)
            }

        })


        return view
    }
}