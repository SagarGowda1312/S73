package com.example.s7

import android.app.Activity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
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
 * Shows a list using a RecyclerView.
 */
class New3Activity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new4)

        // Create a RecyclerView, a LayoutManager, a data Adapter and wire everything up.
        val recyclerView = findViewById<View>(R.id.recyclerView) as RecyclerView
        val layoutManager = LinearLayoutManager(applicationContext)
        recyclerView.setLayoutManager(layoutManager)
        val dataSet: MutableList<String> =
            ArrayList<String>(com.example.s7.New3Activity.Companion.DATASET_COUNT)
        for (i in 0 until com.example.s7.New3Activity.Companion.DATASET_COUNT) {
            dataSet.add("This is element #$i")
        }
        val adapter = CustomAdapter(dataSet, applicationContext)
        recyclerView.setAdapter(adapter)
    }

    companion object {
        private const val DATASET_COUNT = 50
    }
}
