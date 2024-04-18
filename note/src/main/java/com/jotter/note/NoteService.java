package com.jotter.note;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public interface NoteService {

    public ArrayList<HashMap<String, Object>> getAllNotes();

    public ArrayList<HashMap<String, Object>> addNewNote(String title, String body);

    public ArrayList<HashMap<String, Object>> deleteNoteById(String id);

    public ArrayList<HashMap<String, Object>> getNoteById (String id);

    public ArrayList<HashMap<String, Object>> updateNote(String id, String title, String body);
}
