package com.example.notekeeper.activities

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.espresso.contrib.DrawerActions
import androidx.test.espresso.contrib.NavigationViewActions
import androidx.test.espresso.contrib.RecyclerViewActions
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

    }
}