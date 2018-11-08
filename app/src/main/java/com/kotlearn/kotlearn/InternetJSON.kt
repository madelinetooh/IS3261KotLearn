package com.kotlearn.kotlearn

import android.content.Context
import android.os.AsyncTask
import android.widget.TextView
import android.widget.Toast
import org.json.JSONObject
import java.io.BufferedInputStream
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.MalformedURLException
import java.net.URL
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

class InternetJSON(private val c: Context, private var jsonURL: String, private var program: String,
                   private var resultTextView: TextView): AsyncTask<Void, Void, String>(){

    override fun doInBackground(vararg params: Void?): String {

        return download()

    }

    override fun onPostExecute(jsonData: String) {
        super.onPostExecute(jsonData)

        if (jsonData.startsWith("URL ERROR")){
            val error = jsonData
            Toast.makeText(c, error, Toast.LENGTH_LONG).show()
            Toast.makeText(c, "connection problem: most probably due to wrong URL", Toast.LENGTH_LONG).show()

        } else if (jsonData.startsWith("CONNECT ERROR")) {
            val error = jsonData
            Toast.makeText(c, error, Toast.LENGTH_LONG).show()
            Toast.makeText(c, "connection problem: most probably cannot connect to network",
                    Toast.LENGTH_LONG).show()

        } else {
            JSONParser(c, jsonData, resultTextView).execute()
        }
    }

    private fun connect(jsonURL: String): Any {
        try {
            val url = URL(jsonURL)
            val con = url.openConnection() as HttpURLConnection
            println("TEST VALUE $program")
            con.requestMethod = "POST"
            val encode = URLEncoder.encode(program, "UTF-8")
            val test = "LanguageChoiceWrapper=43&Program=$encode"
            con.outputStream.write(test.toByteArray(StandardCharsets.UTF_8))
            con.outputStream.close()

            return con

        } catch (e: MalformedURLException) {
            e.printStackTrace()
            return "URL ERROR" + e.message

        } catch (e: IOException) {
            e.printStackTrace()
            return "CONNECT ERROR" + e.message
        }
    }

    private fun download(): String {
        val connection = connect(jsonURL)
        if (connection.toString().contains("ERROR")) {
            return connection.toString()
        }

        try {
            val con = connection as HttpURLConnection
            if (con.responseCode == 200) {
                val bis = BufferedInputStream(con.inputStream)
                val br  = BufferedReader(InputStreamReader(bis))
                val jsonData = StringBuffer()
                var line: String?

                do {
                    line = br.readLine()
                    if (line == null) {
                        break
                    }
                    jsonData.append(line + "\n")

                } while (true)

                br.close()
                bis.close()
                return jsonData.toString()
            } else {
                return "Error" + con.responseMessage
            }
        } catch (e: IOException) {
            e.printStackTrace()
            return "Error" + e.message
        }
    }
}