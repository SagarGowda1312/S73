package com.example.s7

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

/*
* Copyright 2016, The Android Open Source Project
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*      http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
/**
 * Provides views to [RecyclerView] with data from a data set.
 */
class CustomAdapter internal constructor(private val mDataSet: List<String>, private val mContext: Context) : RecyclerView.Adapter<com.example.s7.CustomAdapter.ViewHolder>() {
    /**
     * Provide a reference to the type of views that you are using
     * (custom [RecyclerView.ViewHolder]).
     */
    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        var textView: TextView

        // We'll use this field to showcase matching the holder from the test.
        private var mIsInTheMiddle: Boolean = false

        init {
            textView = v.findViewById<View>(R.id.textView) as TextView
        }

        fun getTextView2(): TextView {
            return textView
        }

        fun getIsInTheMiddle(): Boolean {
            return mIsInTheMiddle
        }

        fun setIsInTheMiddle(isInTheMiddle: Boolean) {
            mIsInTheMiddle = isInTheMiddle
        }
    }

    override fun onCreateViewHolder(
        viewGroup: ViewGroup,
        viewType: Int
    ): com.example.s7.CustomAdapter.ViewHolder {
        // Create a new view.
        val v: View = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.activity_new5, viewGroup, false)
        return com.example.s7.CustomAdapter.ViewHolder(v)
    }

    override fun onBindViewHolder(viewHolder: com.example.s7.CustomAdapter.ViewHolder, position: Int) {
        if (position == mDataSet.size / 2 /* calculate middle element position */) {
            viewHolder.setIsInTheMiddle(true)
            viewHolder.getTextView2().setText(("This is middle"))
        } else {
            viewHolder.setIsInTheMiddle(false)
            viewHolder.getTextView2().setText(mDataSet[position])
        }
    }

    // Return the size of your data set (invoked by the layout manager)
    override fun getItemCount(): Int {
        return mDataSet.size
    }
}
