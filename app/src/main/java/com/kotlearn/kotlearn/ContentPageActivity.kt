package com.kotlearn.kotlearn

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.Html
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_content_page.*

class ContentPageActivity : AppCompatActivity() {
    lateinit var contentString: String
    lateinit var sharedPreferences: SharedPreferences
    private var myPreferences = "myPrefs"
    private var CODE = "code"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content_page)
        sharedPreferences = getSharedPreferences(myPreferences, Context.MODE_PRIVATE)
        val linearLayout = findViewById<LinearLayout>(R.id.content_layout_activity)
        btn_back_main.setOnClickListener {
            finish()
        }
        contentString = intent.getStringExtra("content")
        contentString = contentString.replace("H1HERE", "<h1>")
        contentString = contentString.replace("H1ENDHERE", "</h1>")
        contentString = contentString.replace("H2HERE", "<h2>")
        contentString = contentString.replace("H2ENDHERE", "</h2>")
        contentString = contentString.replace("CODEHERE", "<code>")
        contentString = contentString.replace("CODEENDHERE", "</code>")
        contentString = contentString.replace("RESULTHERE", "<result>")
        contentString = contentString.replace("RESULTENDHERE", "</result>")
        contentString = contentString.replace("BOLDHERE", "<b>")
        contentString = contentString.replace("BOLDENDHERE", "</b>")
        contentString = contentString.replace("BREAKHERE", "<br/>")

        contentString = contentString.replace("<h1>",
                "<h1><font color='#E91E63' size='20'>")
        contentString = contentString.replace("</h1>", "</font></h1>")

        contentString = contentString.replace("<h2>",
                "<h2><font color='#692D42'>")
        contentString = contentString.replace("</h2>", "</font></h2>")

        contentString = contentString.replace("<b>",
                "<b><font color='#690E2D'>")
        contentString = contentString.replace("</b>", "</font></b>")
        processContent(contentString, linearLayout, this)
    }

    private fun processContent(content: String, linearLayout: LinearLayout, context: Context) {
        if (content == "") return
        if (!content.startsWith("<code>") && !content.startsWith("<result>")) {
            var codeIndex = content.indexOf("<code>")
            val resultIndex = content.indexOf("<result>")
            codeIndex = if (codeIndex < 0) resultIndex else codeIndex
            val codePos = Math.min(codeIndex, resultIndex)
            val contentLayout = layoutInflater.inflate(R.layout.content_layout, null)
            val textView = contentLayout.findViewById<TextView>(R.id.content_text)
            if (codePos == -1) {
                textView.text = Html.fromHtml(content)
                linearLayout.addView(contentLayout)
            } else {
                textView.text = Html.fromHtml(content.substring(0, codePos))
                linearLayout.addView(contentLayout)
                processContent(content.substring(codePos), linearLayout, context)
            }
        } else if (content.startsWith("<code>")) {
            val codePos = content.indexOf("</code>")
            val codeSnippetLayout = layoutInflater.inflate(R.layout.code_snippet_layout, null)
            val textView = codeSnippetLayout.findViewById<TextView>(R.id.code_content)
            val runCodeButton = codeSnippetLayout.findViewById<Button>(R.id.run_code_button)
            var code = content.substring(6, codePos)
//            code = code.replace(" ", "&nbsp;")
            runCodeButton.setOnClickListener {
                val myIntent = Intent()
                val editor = sharedPreferences.edit()
                editor.putString(CODE, code)
                editor.apply()
                myIntent.putExtra("compiler", true)
                setResult(Activity.RESULT_OK, myIntent)
                finish()
            }
            textView.text = Html.fromHtml(code)
            linearLayout.addView(codeSnippetLayout)
            processContent(content.substring(codePos + 7), linearLayout, context)
        } else if (content.startsWith("<result>")) {
            val codePos = content.indexOf("</result>")
            val codeResultLayout = layoutInflater.inflate(R.layout.code_result_layout, null)
            val textView = codeResultLayout.findViewById<TextView>(R.id.result_text)
            textView.text = Html.fromHtml("<i>" + content.substring(8, codePos) + "</i>")
            linearLayout.addView(codeResultLayout)
            processContent(content.substring(codePos + 9), linearLayout, context)
        }
    }
}
