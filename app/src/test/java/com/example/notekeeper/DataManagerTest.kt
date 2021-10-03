package com.example.notekeeper

import junit.framework.TestCase
import org.junit.Before
import org.junit.Test

class DataManagerTest : TestCase() {
    @Before
    override fun setUp() {
        DataManager.notes.clear()
        DataManager.initializeNotes()
    }
    @Test
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
    @Test
    fun testFindNote() {
        val course  = DataManager.courses.get("android_async")!!
        val noteTitle = "Async Tests"
        val noteText = "This is a test"
        val noteText1 = "This is a test 1"

        val index1 = DataManager.addNote(course, noteTitle, noteText)
        val index2 = DataManager.addNote(course, noteTitle, noteText1)

        val note1 = DataManager.findNote(course, noteTitle, noteText)
        val foundIndex1 = DataManager.notes.indexOf(note1)
        assertEquals(index1, foundIndex1)

        val note2 = DataManager.findNote(course, noteTitle, noteText1)
        val foundIndex2 = DataManager.notes.indexOf(note2)
        assertEquals(index2, foundIndex2)
    }
}