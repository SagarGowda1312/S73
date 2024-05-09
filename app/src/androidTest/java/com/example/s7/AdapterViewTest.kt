package com.example.s7

import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.PerformException
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule

import org.hamcrest.Matchers
import org.junit.Rule
import org.junit.Test

class AdapterViewTest {
    @get:Rule
    val activity = ActivityScenarioRule(New2Activity::class.java)


@Test
fun whenAppOpen_TextExists(){
    onView(withText("item: 100")).check(ViewAssertions.doesNotExist())

}


    @Test
fun whenAppOpens(){
    onView(withText("item: 65")).check(ViewAssertions.doesNotExist())
}
    @Test
    fun whenScrollToLastItem_ThenLastItemIsDisplayed(){
        onData(
            Matchers.hasEntry(
                Matchers.equalTo(New2Activity.ROW_TEXT),
                Matchers.`is`("item: 99")
            )
        )
    }

    @Test
    fun whenClickOnRow_ThenTheTextIsUpdated() {
        val itemToClickOn = "item: 30"
        Espresso.onData(
            Matchers.hasEntry(
                Matchers.equalTo(New2Activity.ROW_TEXT),
                Matchers.`is`(itemToClickOn)
            )
        ) // To click on an element in the list use `onChildView`
            .onChildView(withId(R.id.rowContentTextView))
            .perform(ViewActions.click())

        // Now that we are on desired item, we can verify using onView method
        Espresso.onView(withId(R.id.selection_row_value))
            .check(ViewAssertions.matches(withText("30")))
    }



    @Test
    fun checkEmptyFieldInRowTitle() {
        // Now that we are on desired item, we can verify using onView method
        Espresso.onView(withId(R.id.selection_row_value))
            .check(ViewAssertions.matches(withText("")))
    }



    @Test
    fun whenClickOnButton_Testbuttovalue(){
        val itemToClickOn = "item: 30"
        Espresso.onData(
            Matchers.hasEntry(
                Matchers.equalTo(New2Activity.ROW_TEXT),
                Matchers.`is`(itemToClickOn)
            )
        )
            .onChildView(withId(R.id.rowToggleButton))
            .perform(ViewActions.click())
            .check(ViewAssertions.matches(ViewMatchers.isChecked()))
            .perform(ViewActions.click())
            .check(ViewAssertions.matches(ViewMatchers.isNotChecked()))


    }




    @Test
    fun whenClickOnAllButtons(){
        var i=2
        while(i<100)
        {
            val itemToClickOn = "item: $i"
            Espresso.onData(
                Matchers.hasEntry(
                    Matchers.equalTo(New2Activity.ROW_TEXT),
                    Matchers.`is`(itemToClickOn)
                )
            )
                .onChildView(withId(R.id.rowToggleButton))
                .perform(ViewActions.click())
                .check(ViewAssertions.matches(ViewMatchers.isChecked()))

       i++
        }
    }











}