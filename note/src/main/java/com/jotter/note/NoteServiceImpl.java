package com.jotter.note;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class NoteServiceImpl implements NoteService{

    private static ArrayList<HashMap<String, Object>> noteList = new ArrayList<HashMap<String, Object>>();

    @Override
    public ArrayList<HashMap<String, Object>> getAllNotes(){
       return noteList;
    }

    @Override
    public ArrayList<HashMap<String, Object>> addNewNote(String title, String body){
        HashMap<String, Object> newNote = new HashMap<String, Object>();
        //Setting up the ID
        String idFnl = "0";
        if(noteList.size() > 0){
            for(int i = 0; i < noteList.size(); i++){
                int idPrev = (i > 0) ? Integer.parseInt((String) noteList.get(i-1).get("id")) : 0;
                int id = Integer.parseInt((String) noteList.get(i).get("id"));

                if(id > idPrev){
                    idFnl = String.valueOf(id + 1 );
                }
            }
        }else{
            idFnl = "1";
        }

        NotePOJO notePOJO = new NotePOJO(idFnl, title, body);
        newNote.put("id", notePOJO.getId());
        newNote.put("title", notePOJO.getTitle());
        newNote.put("body", notePOJO.getBody());
        noteList.add(newNote);
        return noteList;
    }

    @Override
    public ArrayList<HashMap<String, Object>>  deleteNoteById (String id){
        for(int i = 0; i < noteList.size(); i++){
            if(noteList.get(i).get("id").equals(id)){
                noteList.remove(i);
            }
        }
        return noteList;
    }

    @Override
    public ArrayList<HashMap<String, Object>> getNoteById (String id){
        ArrayList<HashMap<String, Object>> note = new ArrayList<HashMap<String, Object>>();
        for(int i = 0; i < noteList.size(); i++){
            if(noteList.get(i).get("id").equals(id)){
                note.add(noteList.get(i));
            }
        }
        return note;
    }

    @Override
    public ArrayList<HashMap<String, Object>> updateNote(String id, String title, String body){
        for(int i = 0; i < noteList.size(); i++){
            if(noteList.get(i).get("id").equals(id)){
                noteList.get(i).replace("title", title);
                noteList.get(i).replace("body", body);
            }
        }
        return noteList;
    }
}
