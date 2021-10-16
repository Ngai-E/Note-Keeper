package com.example.notekeeper.activities

import androidx.test.espresso.Espresso.*
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.espresso.contrib.DrawerActions
import androidx.test.espresso.contrib.NavigationViewActions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import com.example.notekeeper.CourseInfo
import com.example.notekeeper.DataManager
import com.example.notekeeper.R
import com.example.notekeeper.adapters.CourseRecyclerAdapter
import com.example.notekeeper.adapters.NoteRecyclerAdapter
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class NavigationTest {

    @Rule @JvmField
    val itemsActivityScenarioRule = ActivityScenarioRule(ItemsActivity::class.java)

    @Test
    public  fun selectNoteAfterNavigationDrawerChange() {
        onView(withId(R.id.drawer_layout)).perform(DrawerActions.open())
        onView(withId(R.id.nav_view)).perform(NavigationViewActions.navigateTo(R.id.nav_courses))

        val courseInfoPosition = 0
        onView(withId(R.id.listItems)).perform(
            RecyclerViewActions.actionOnItemAtPosition<CourseRecyclerAdapter.ViewHolder>(courseInfoPosition, click())
        )

        onView(withId(R.id.drawer_layout)).perform(DrawerActions.open())
        onView(withId(R.id.nav_view)).perform(NavigationViewActions.navigateTo(R.id.nav_notes))

        val notesPosition = 0
        onView(withId(R.id.listItems)).perform(
            RecyclerViewActions.actionOnItemAtPosition<NoteRecyclerAdapter.ViewHolder>(notesPosition, click())
        )

        val note = DataManager.notes[notesPosition]
        onView(withId(R.id.spinnerCourses)).check(matches(withSpinnerText(note.course?.title)))
        onView(withId(R.id.textNodeTitle)).check(matches(withText(note.title)))
        onView(withId(R.id.textNoteText)).check(matches(withText(note.text)))
    }
}