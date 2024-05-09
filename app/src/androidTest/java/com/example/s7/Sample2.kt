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
class Sample2 {
    @get:Rule
    var activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun test1() {
        onView(ViewMatchers.withId(R.id.textToBeChanged))
            .check(ViewAssertions.matches(ViewMatchers.withText("hello_world")))
    }

    @Test
    fun test2() {
        onView(ViewMatchers.withId(R.id.changeTextBt))
            .check(ViewAssertions.matches(ViewMatchers.withText("CHANGE_TEXT")))

    }

    @Test
    fun test3() {
        onView(ViewMatchers.withId(R.id.activityChangeTextBtn))
            .check(ViewAssertions.matches(ViewMatchers.withText("OPEN_ACTIVITY_AND_CHANGE_TEXT")))
    }

    @Test
    fun test4() {
        onView(ViewMatchers.withId(R.id.editTextUserInput))
            .check(ViewAssertions.matches(ViewMatchers.withHint("n")))
    }

    @Test
    fun test5() {
        val text = "Hello IGS"
        onView(ViewMatchers.withId(R.id.editTextUserInput))
            .perform(ViewActions.typeText(text), ViewActions.closeSoftKeyboard())

        onView(ViewMatchers.withId(R.id.changeTextBt))
            .perform(ViewActions.click())

        onView(ViewMatchers.withId(R.id.textToBeChanged))
            .check(ViewAssertions.matches(ViewMatchers.withText("Waitttttt brooooooo")))
    }
    @Test
    fun test6() {

        onView(ViewMatchers.withId(R.id.changeTextBt))
            .perform(ViewActions.click())

        onView(ViewMatchers.withId(R.id.textToBeChanged))
            .check(ViewAssertions.matches(ViewMatchers.withText("Waitttttt brooooooo")))
    }

    @Test
    fun test7() {
        val text = "IGS"
        onView(ViewMatchers.withId(R.id.editTextUserInput))
            .perform(ViewActions.typeText(text), ViewActions.closeSoftKeyboard())

        onView(ViewMatchers.withId(R.id.activityChangeTextBtn))
            .perform(ViewActions.click())

        onView(ViewMatchers.withId(R.id.textView2))
            .check(ViewAssertions.matches(ViewMatchers.withText(text)))
    }

    @Test
    fun test8() {

        onView(ViewMatchers.withId(R.id.activityChangeTextBtn))
            .perform(ViewActions.click())

        onView(ViewMatchers.withId(R.id.textView2))
            .check(ViewAssertions.matches(ViewMatchers.withText("")))
    }
}