package com.jwhh.jim.notekeeper;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DataManagerTest {

    @Test
    public void createNewNote() throws Exception {
        final DataManager manager = DataManager.getInstance();
        final CourseInfo myCourse = manager.getCourse("android-async");
        final String noteTitle = "Test Title";
        final String noteContents = "This is the content of the test node";

        int testNodeIndex = manager.createNewNote();

        NoteInfo testNewNote = manager.getNotes().get(testNodeIndex);
        testNewNote.setCourse(myCourse);
        testNewNote.setTitle(noteTitle);
        testNewNote.setText(noteContents);

        NoteInfo compareNote = manager.getNotes().get(testNodeIndex);

        assertEquals(compareNote.getCourse(), myCourse);
        assertEquals(compareNote.getTitle(), noteTitle);
        assertEquals(compareNote.getText(), noteContents);
    }
}