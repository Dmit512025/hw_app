package com.netology.mqa_lesson_2_1

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.netology.tabbedapplication.MainActivity
import com.netology.tabbedapplication.R
import org.hamcrest.CoreMatchers.allOf
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class TabSwitchingTest {

    @Test
    fun tabSwitchingTest() {
        ActivityScenario.launch(MainActivity::class.java)

        // контент первой страницы виден
        onView(allOf(withId(R.id.section_label), isDisplayed()))
            .check(matches(isDisplayed()))

        // переключаемся на вторую вкладку
        onView(withText(R.string.tab_text_2)).perform(click())

        // контент второй страницы отображается
        onView(allOf(withId(R.id.section_label), isDisplayed()))
            .check(matches(isDisplayed()))
    }
}
