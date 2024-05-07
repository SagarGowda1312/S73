package com.example.s7

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.PerformException
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class RecyclerView2 {

    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(New3Activity::class.java)

    @Test(expected = PerformException::class)
    fun whenAppLaunches() {
        onView(ViewMatchers.withId(R.id.recyclerView))
            .perform(
                RecyclerViewActions.scrollTo<RecyclerView.ViewHolder>(
                    ViewMatchers.hasDescendant(
                        ViewMatchers.withText("not in the list")
                    )
                ))

    }

    @Test
    fun scrollToSpecificLocation() {
        val element1:Int = 20
        onView(ViewMatchers.withId(R.id.recyclerView))
            .perform(
                RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                    element1
                )
            )
        val textDisplayed = "This is element #$element1"
        onView(ViewMatchers.withText(textDisplayed))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun whenScrollToMiddle() {
        onView(ViewMatchers.withId(R.id.recyclerView))
            .perform(
                RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                    25
                )
            )
        Espresso.onView(ViewMatchers.withText("This is middle"))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

}