package com.example.s7

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.IdlingResource
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith



@LargeTest
@RunWith(AndroidJUnit4::class)
class Sample3 {

    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    private var mIdlingResource: IdlingResource? = null


    @Before
    fun registerIdlingResource() {
        val activityScenario: ActivityScenario<MainActivity> =
            ActivityScenario.launch(MainActivity::class.java)
        activityScenario.onActivity { activity ->                //REgistering idle resources.
            mIdlingResource = activity.idlingResource
            IdlingRegistry.getInstance().register(mIdlingResource)
        }
    }
    @Test
    fun idling1() {
        val text = "HELLO IGS, WELCOME"
        onView(ViewMatchers.withId(R.id.editTextUserInput))
            .perform(ViewActions.typeText(text) , ViewActions.closeSoftKeyboard())

        onView(ViewMatchers.withId(R.id.changeTextBt))
            .perform(ViewActions.click())

        onView(ViewMatchers.withId(R.id.textToBeChanged))
            .check(ViewAssertions.matches(ViewMatchers.withText(text)))
    }

    @Test
    fun idling2() {
        onView(ViewMatchers.withId(R.id.changeTextBt))
            .perform(ViewActions.click())

        onView(ViewMatchers.withId(R.id.textToBeChanged))
            .check(ViewAssertions.matches(ViewMatchers.withText("")))

    }

    @After
    fun unregisterIdlingResource() {
        if (mIdlingResource != null) {
            IdlingRegistry.getInstance().unregister(mIdlingResource)
        }
    }

}