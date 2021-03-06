package com.kotlearn.kotlearn

import android.app.Activity
import android.content.Context
import android.content.Intent
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
    val REQUEST_CODE : Int = 1

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        contentString = if (arguments != null) arguments!!.getString("code") else ""
        val context = this@CompilerFragment.activity!!.applicationContext
        sharedPreferences = context.getSharedPreferences(myPreferences, Context.MODE_PRIVATE)
        val view: View = inflater.inflate(R.layout.fragment_compiler, container, false)

        val input = view.code_editor

        view.btn_run.setOnClickListener {
            view.progressBar.visibility = View.VISIBLE
            view.result_textview.visibility = View.GONE
            InternetJSON(context,"https://rextester.com/rundotnet/Run", view.code_editor.text.toString(),
                    view.result_textview, view.progressBar).execute()
        }

        view.btn_clear.setOnClickListener {
            input.setText("")
            view.result_textview.text = ""
            view.lineCount.text = "1"
            val editor = sharedPreferences.edit()
            editor.putString(CODE, "")
            editor.apply()
        }

        view.btn_scanQR.setOnClickListener {
            val qrIntent = Intent(context, QRScanner::class.java)
            startActivityForResult(qrIntent, REQUEST_CODE)
        }

        input.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                var lines = code_editor.lineCount
                var linestext = ""
                for (i in 1..lines) {
                    linestext = linestext + i + "\n"
                }
                lineCount.text = linestext
            }
        })

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val context = this@CompilerFragment.activity!!.applicationContext
        sharedPreferences = context.getSharedPreferences(myPreferences, Context.MODE_PRIVATE)
        val codeEditor = view.findViewById<EditText>(R.id.code_editor)
        setCodeText(codeEditor, true)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if ((requestCode == REQUEST_CODE) && (resultCode == Activity.RESULT_OK)) {
            setCodeText(code_editor, false)
        }
    }

    fun setCodeText(codeEditor: EditText, isHtml: Boolean) {
        var codeContent = sharedPreferences.getString(CODE, empty)
        if (codeContent != empty) {
            if (isHtml) {
                codeContent = codeContent.replace("<br/>", "\n")
                codeContent = codeContent.replace("&lt;", "<")
                codeContent = codeContent.replace("&gt;", ">")
            }
            codeEditor.setText(codeContent)
            codeEditor.post {
                var lines = codeEditor.lineCount
                var linestext = ""
                for (i in 1..lines) linestext = linestext + i + "\n"
                lineCount.text = linestext
            }
        } else {
            lineCount.text = "1"
        }
        codeEditor.setOnFocusChangeListener { _, _ ->
            run {
                val editor = sharedPreferences.edit()
                editor.putString(CODE, Html.toHtml(codeEditor.text))
                editor.apply()
            }
        }
    }
}