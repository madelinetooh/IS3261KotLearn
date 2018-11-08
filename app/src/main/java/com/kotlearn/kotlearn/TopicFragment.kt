package com.kotlearn.kotlearn

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

class TopicFragment : android.support.v4.app.Fragment() {
    lateinit var contentString: String
    lateinit var sharedPreferences: SharedPreferences
    private var myPreferences = "myPrefs"
    private var CODE = "code"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        contentString = arguments!!.getString("content")
        return inflater.inflate(R.layout.fragment_topic, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        val contentTextView = view.findViewById<TextView>(R.id.content_textview)
        val context = this@TopicFragment.activity!!.applicationContext
        sharedPreferences = context.getSharedPreferences(myPreferences, Context.MODE_PRIVATE)
        val linearLayout = view.findViewById<LinearLayout>(R.id.content_layout)
        val bottomNav = activity!!.findViewById<BottomNavigationView>(R.id.navigation)

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
        processContent(contentString, linearLayout, context, bottomNav)
    }

    private fun processContent(content: String, linearLayout: LinearLayout, context: Context, bottomNav: BottomNavigationView) {
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
                processContent(content.substring(codePos), linearLayout, context, bottomNav)
            }
        } else if (content.startsWith("<code>")) {
            val codePos = content.indexOf("</code>")
            val codeSnippetLayout = layoutInflater.inflate(R.layout.code_snippet_layout, null)
            val textView = codeSnippetLayout.findViewById<TextView>(R.id.code_content)
            val runCodeButton = codeSnippetLayout.findViewById<Button>(R.id.run_code_button)
            var code = content.substring(6, codePos)
//            code = code.replace(" ", "&nbsp;")
            runCodeButton.setOnClickListener {
                bottomNav.menu.findItem(R.id.navigation_complier).isChecked = true
                val editor = sharedPreferences.edit()
                editor.putString(CODE, code)
                editor.apply()
                val compilerFragment = CompilerFragment()
                fragmentManager!!.beginTransaction().replace(R.id.fragment_container, compilerFragment).commit()
            }
            textView.text = Html.fromHtml(code)
            linearLayout.addView(codeSnippetLayout)
            processContent(content.substring(codePos + 7), linearLayout, context, bottomNav)
        } else if (content.startsWith("<result>")) {
            val codePos = content.indexOf("</result>")
            val codeResultLayout = layoutInflater.inflate(R.layout.code_result_layout, null)
            val textView = codeResultLayout.findViewById<TextView>(R.id.result_text)
            textView.text = Html.fromHtml("<i>" + content.substring(8, codePos) + "</i>")
            linearLayout.addView(codeResultLayout)
            processContent(content.substring(codePos + 9), linearLayout, context, bottomNav)
        }
    }
}