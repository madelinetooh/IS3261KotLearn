package com.kotlearn.kotlearn

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListAdapter
import android.widget.ListView

class ContentFragment : android.support.v4.app.Fragment() {
    private lateinit var topicDbHelper: DBHelper
    private lateinit var adapter: ListAdapter
    private lateinit var topicHeaderArray: List<String>
    private lateinit var topicIdArray: List<Int>
    private val REQUEST_CODE : Int = 2

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        topicDbHelper = DBHelper(this@ContentFragment.activity!!.applicationContext)
        val allTopics = topicDbHelper.readAllTopics()
//        if (allTopics.isEmpty()) {
//            InternetJSON(this@ContentFragment.activity!!.applicationContext,"http://172.19.195.190:8080/KotlearnBackend-war/resources/topics/getTopics",
//                    topicDbHelper).execute()
//        }
        topicHeaderArray = allTopics.map { it.topicHeader }
        topicIdArray = allTopics.map { it.id }
        adapter = ArrayAdapter<String>(this@ContentFragment.activity!!.applicationContext,
                R.layout.list_item_layout, R.id.list_content, topicHeaderArray)

        return inflater.inflate(R.layout.fragment_content, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val topicListView = view!!.findViewById<ListView>(R.id.topicList)
        topicListView.adapter = adapter

        topicListView.setOnItemClickListener{ parent, view, position, id ->
            run {
                val selectedId = topicIdArray.get(position)
                val readTopic = topicDbHelper.readTopic(selectedId)
                val myIntent = Intent(context, ContentPageActivity::class.java)
                myIntent.putExtra("content", readTopic[0].topicContent)
                startActivityForResult(myIntent, REQUEST_CODE)
            }
        }
    }
}