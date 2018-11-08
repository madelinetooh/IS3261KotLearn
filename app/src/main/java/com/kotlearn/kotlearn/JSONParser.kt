package com.kotlearn.kotlearn

import android.content.Context
import android.os.AsyncTask
import android.widget.TextView
import android.widget.Toast
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject

class JSONParser(private var c: Context, private var jsonData: String,
                 private val resultTextView: TextView): AsyncTask<Void, Void, Boolean>() {

    private var result = ""
    private var exception = ""

    override fun doInBackground(vararg voids: Void): Boolean? {
        return parse()
    }

    override fun onPostExecute(isParsed: Boolean?) {
        super.onPostExecute(isParsed)

        if (isParsed!!) {

//            Toast.makeText(c, "parse successful -- " + topics.size
//                    + " " + topics[topics.size - 1].id + ", "
//                    + topics[topics.size - 1].topicHeader, Toast.LENGTH_LONG).show()

//            topics.forEach{dbHelper.insertTopic(it)}
            resultTextView.text = if (result.equals("null")) exception else result
//            resultTextView.text = jsonData

        } else {
            Toast.makeText(c, "Unable to Parse that data.", Toast.LENGTH_LONG).show()
            Toast.makeText(c, "This is the data that we are trying to parse : $jsonData",
                    Toast.LENGTH_LONG).show()
        }
    }

    private fun parse(): Boolean {
        try {
//            val ja = JSONArray(jsonData)
            var jo = JSONObject(jsonData)

            result = jo.getString("Result")
            exception = jo.getString("Errors")

//            for (i in 0 until ja.length()) {
//                jo = ja.getJSONObject(i)
//
//                val id = jo.getInt("id")
//                val topicHeader = jo.getString("text")
//                val topicContent = jo.getString("content")
//
//                topic = TopicRecord(id, topicHeader, topicContent)
//                topics.add(topic)
//            }
            return true
        } catch (e: JSONException) {
            e.printStackTrace()
            return false
        }
    }
}