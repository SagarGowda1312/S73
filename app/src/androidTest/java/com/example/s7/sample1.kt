package com.example.s7

import android.content.Intent
import android.net.Uri
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.rule.GrantPermissionRule
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.matcher.IntentMatchers
import androidx.test.espresso.matcher.ViewMatchers
import org.hamcrest.core.AllOf
import org.junit.After
import org.junit.Test

@RunWith(AndroidJUnit4::class)
@LargeTest
class sample1 {

    @get:Rule
    var grantPermissionRule = GrantPermissionRule.grant("android.permission.CALL_PHONE")

    @get:Rule
    var testRule = ActivityScenarioRule(
        MainActivity::class.java
    )

    @Before
    fun setUpIntents() {
        Intents.init()

    }

    /** Test to enter a phone number and make a call and verify an intent is launched  */
    @Test
    fun test1() {
        val number =  "8431186477"
        val phoneNumber = Uri.parse("tel:" + number)
        onView(ViewMatchers.withId(R.id.editTextUserInput))
            .perform(ViewActions.typeText(number), ViewActions.closeSoftKeyboard())

        onView(ViewMatchers.withId(R.id.activityChangeTextBtn))
            .perform(ViewActions.click())

        onView(ViewMatchers.withId(R.id.call_btn))
            .perform(ViewActions.click())

        Intents.intended(
            AllOf.allOf(
                IntentMatchers.hasAction(Intent.ACTION_CALL),
                IntentMatchers.hasData(phoneNumber)


            )

        )
    }

    @After
    fun teardownIntents() {
        // Clears intent state, must be called after each test case
        Intents.release()
    }





}