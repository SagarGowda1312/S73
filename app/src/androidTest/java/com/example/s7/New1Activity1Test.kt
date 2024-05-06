package com.example.s7

import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewAssertion
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Rule
import org.junit.Test

class New1Activity1Test {

    @get:Rule
    val activity = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun test_Input_Text() {
        val user_input="Sagar"
        onView(ViewMatchers.withId(R.id.editTextUserInput))
            .perform(ViewActions.typeText(user_input))

        onView(ViewMatchers.withId(R.id.activityChangeTextBtn))
            .perform(ViewActions.click())

        onView(ViewMatchers.withId(R.id.textView2))
            .check(ViewAssertions.matches(ViewMatchers.withText(user_input)))
    }

    @Test
    fun test_blank_entry(){
        val blank_input=""
        onView(ViewMatchers.withId(R.id.activityChangeTextBtn))
            .perform(ViewActions.click())

        onView(ViewMatchers.withId(R.id.textView2))
            .check(ViewAssertions.matches(ViewMatchers.withText(blank_input)))

    }






}