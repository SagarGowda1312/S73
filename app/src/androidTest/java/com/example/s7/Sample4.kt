package com.example.s7

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class Sample4 {

    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(New1Activity::class.java)

    @Test
    fun test1() {
        onView(ViewMatchers.withId(R.id.call_btn))
            .check(ViewAssertions.matches(ViewMatchers.withText("CALL NUMBER")))
            .perform(ViewActions.click())

    }

    @Test
    fun test2() {
        onView(ViewMatchers.withId(R.id.button_pick_contact))
            .check(ViewAssertions.matches(ViewMatchers.withText("CONTACTS")))
            .perform(ViewActions.click())
    }


    @Test
    fun test3() {
        onView(ViewMatchers.withId(R.id.button_pick_contact2))
            .check(ViewAssertions.matches(ViewMatchers.withText("REELS")))
            .perform(ViewActions.click())
    }

}