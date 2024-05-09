package com.example.s7

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.PerformException
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Rule
import org.junit.Test

class RecyclerViewTest {



    @get:Rule
    var activityScenarioRule: ActivityScenarioRule<*> = ActivityScenarioRule(
        New3Activity::class.java
    )

    @Test(expected = PerformException::class)
    fun whenAppLaunches(){
onView(ViewMatchers.withId(R.id.recyclerView))
    .perform(
        RecyclerViewActions.scrollTo<RecyclerView.ViewHolder>(
            ViewMatchers.hasDescendant(
                ViewMatchers.withText("not on the list")
            )
        )
    )
    }


    @Test
    fun whenScrollToSpecficPositon(){
        val itemBelowFold = 40
        Espresso.onView(ViewMatchers.withId(R.id.recyclerView))
            .perform(
                RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                    itemBelowFold
                )
            )
        val expectedText = String.format("This is element #%d", itemBelowFold)
        onView(ViewMatchers.withText(expectedText))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed())
            )
    }












    @Test
    fun whenScrollToItemInTheMiddle_ThenCheckItemWithSpecialTextIsDisplayed() {

        Espresso.onView(ViewMatchers.withId(R.id.recyclerView)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                25
            )
        )
        Espresso.onView(ViewMatchers.withText("This is middle"))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    } }