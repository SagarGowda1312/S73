package com.example.s7

import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.PerformException
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.hamcrest.Matchers
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class Adopterview2 {

    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(New2Activity::class.java)

    @Test
    fun whenAppOpens_LastItemIsNotDisplayed() {
        onView(ViewMatchers.withText("item: 99"))
            .check(ViewAssertions.doesNotExist())
    }

    @Test
    fun whenScrollToLastItem_ThenLastItemIsDisplayed() {
        Espresso.onData(
            Matchers.hasEntry(
                Matchers.equalTo(New2Activity.ROW_TEXT),
                Matchers.`is`("item: 99")
            )
        )
            .check(ViewAssertions.matches(ViewMatchers.isCompletelyDisplayed()))

    }

    @Test
    fun whenAppOpens() {
        onView(ViewMatchers.withText("item: 100"))
            .check(ViewAssertions.doesNotExist())
    }

    @Test
    fun whenClickingOnRow_TextIsUpdated() {
        val itemToClickOn = "item: 30"
        Espresso.onData(
            Matchers.hasEntry(
                Matchers.equalTo(New2Activity.ROW_TEXT),
                Matchers.`is`(itemToClickOn)
            )
        )
            .onChildView(ViewMatchers.withId(R.id.rowContentTextView))
            .perform(ViewActions.click())

        onView(ViewMatchers.withId(R.id.selection_row_value))
            .check(ViewAssertions.matches(ViewMatchers.withText(itemToClickOn)))

    }

    @Test
    fun emptyFieldInRowValue() {
        onView(ViewMatchers.withId(R.id.selection_row_value))
            .check(ViewAssertions.matches(ViewMatchers.withText("")))
    }

    @Test
    fun whenToggledButton() {
        val itemToClickOn = "item: 30"
        Espresso.onData(
            Matchers.hasEntry(
                Matchers.equalTo(New2Activity.ROW_TEXT),
                Matchers.`is`(itemToClickOn)
            )

        )
            .onChildView(ViewMatchers.withId(R.id.rowToggleButton))
            .perform(ViewActions.click())
            .check(ViewAssertions.matches(ViewMatchers.isChecked()))


    }

    @Test
    fun whenClickOnAllButtons() {
        var i = 2
        while(i < 100) {
            var itemToClickOn = "item: $i"
            Espresso.onData(
                Matchers.hasEntry(
                    Matchers.equalTo(New2Activity.ROW_TEXT),
                    Matchers.`is`(itemToClickOn)
                )

            )
                .onChildView(ViewMatchers.withId(R.id.rowToggleButton))
                .perform(ViewActions.click())
                .check(ViewAssertions.matches(ViewMatchers.isChecked()))
            i++

        }
    }

    @Test
    fun whenButtonToggledANdToggledBack_NotChecked() {

    }


}