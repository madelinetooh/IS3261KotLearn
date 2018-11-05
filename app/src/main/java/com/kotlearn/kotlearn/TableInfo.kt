package com.kotlearn.kotlearn

import android.provider.BaseColumns

class TableInfo : BaseColumns {

    companion object {
        val TABLE_NAME = "topics"
        val COLUMN_ID = "id"
        val COLUMN_TOPIC_HEADER = "topicHeader"
        val COLUMN_TOPIC_CONTENT = "topicContent"
    }


}