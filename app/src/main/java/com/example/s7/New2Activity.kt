package com.example.s7

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListAdapter
import android.widget.ListView
import android.widget.SimpleAdapter
import android.widget.TextView
import androidx.annotation.VisibleForTesting
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Maps

/*
* Copyright (C) 2015 The Android Open Source Project
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*   http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

/**
 * An activity displaying a long list with a text view and a toggle button. The last clicked row is
 * displayed at the top.
 */
class New2Activity : Activity() {
    private val data: MutableList<Map<String, Any>> = ArrayList()
    private var layoutInflater: LayoutInflater? = null
    public override fun onCreate(bundle: Bundle?) {
        super.onCreate(bundle)
        setContentView(R.layout.activity_new2)
        populateData()
        val listView = findViewById<View>(R.id.list) as ListView
        val from = arrayOf(ROW_TEXT, ROW_ENABLED)
        val to = intArrayOf(R.id.rowContentTextView, R.id.rowToggleButton)
        layoutInflater = getLayoutInflater()

        // Create the adapter for the list.
        val adapter: ListAdapter = LongListAdapter(from, to)

        // Send the data to the list.
        listView.setAdapter(adapter)
    }

    private fun populateData() {
        for (i in 0 until NUMBER_OF_ITEMS) {
            data.add(makeItem(i))
        }
    }

    private inner class LongListAdapter(from: Array<String>, to: IntArray?) :
        SimpleAdapter(this@New2Activity, data, R.layout.activity_new3, from, to) {
        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
            // Inflate list items.
            val view = convertView ?: layoutInflater?.inflate(R.layout.activity_new3, null)
            convertView?.setOnClickListener {
                (findViewById<View>(R.id.selection_row_value) as TextView).text =
                    position.toString()
            }
            return super.getView(position, convertView, parent)
        }
    }

    companion object {
        @VisibleForTesting
        protected val ROW_TEXT = "ROW_TEXT"

        @VisibleForTesting
        protected val ROW_ENABLED = "ROW_ENABLED"

        @VisibleForTesting
        protected val NUMBER_OF_ITEMS = 100

        @VisibleForTesting
        protected val ITEM_TEXT_FORMAT = "item: %d"
        @VisibleForTesting
        protected fun makeItem(forRow: Int): Map<String, Any> {
            val dataRow: MutableMap<String, Any> =
                Maps.newHashMap<String, Any>()
            dataRow[ROW_TEXT] =
                String.format(ITEM_TEXT_FORMAT, forRow)
            dataRow[ROW_ENABLED] = forRow == 1
            return dataRow
        }
    }
}