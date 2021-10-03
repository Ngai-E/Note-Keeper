package com.example.notekeeper

import junit.framework.TestCase

class DataManagerTest : TestCase() {

    fun testAddNote() {
        val course = DataManager.courses.get("android_async")!!
        val noteTitle = "Async Tests"
        val noteText  = "This is a test"

        val index   = DataManager.addNote(course, noteTitle, noteText)
        val note    = DataManager.notes[index]

        assertEquals(course, note.course)
        assertEquals(noteTitle, note.title)
        assertEquals(noteText, note.text)

    }
}