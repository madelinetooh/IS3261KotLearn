package com.kotlearn.kotlearn

import android.app.FragmentManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListAdapter
import android.widget.ListView

class ContentFragment : android.support.v4.app.Fragment() {
    private lateinit var topicDbHelper: DBHelper
    private lateinit var adapter: ListAdapter
    private lateinit var topicHeaderArray: List<String>
    private lateinit var topicIdArray: List<Int>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        topicDbHelper = DBHelper(this@ContentFragment.activity!!.applicationContext)
        val allTopics = topicDbHelper.readAllTopics()
        if (allTopics.isEmpty()) {
            InternetJSON(this@ContentFragment.activity!!.applicationContext,"http://172.19.195.190:8080/KotlearnBackend-war/resources/topics/getTopics",
                    topicDbHelper).execute()
        }
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
                val topicFragment = TopicFragment()
                topicFragment.arguments = Bundle().apply { putString("content", readTopic.get(0).topicContent) }
                fragmentManager!!.beginTransaction().replace(R.id.fragment_container, topicFragment).commit()
            }
        }
    }
}