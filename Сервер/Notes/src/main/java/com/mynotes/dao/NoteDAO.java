package com.mynotes.dao;

import com.mynotes.model.Note;

import java.util.List;

public interface NoteDAO {
    public void createNote(Note note);

    public void updateNote(Note note);

    public void deleteNote(long id);

    public List<Note> getNotesByPaging(int page,int offset, String filter, String sort);

    public int getSize(String filter);

    public void setIsDone(int id, int done);
}
