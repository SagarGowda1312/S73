package com.example.s7

import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Rule
import org.junit.Test

class New2ActivityTest {


    @get:Rule
    val activity = ActivityScenarioRule(New1Activity::class.java)

    @Test
    fun testText() {
        Espresso.onView(ViewMatchers.withId(R.id.call_btn))
            .check(ViewAssertions.matches(ViewMatchers.withText("CALL NUMBER")))

    }



}