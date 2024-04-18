package com.jotter.note;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestController
public class NoteController {

    @Autowired
    private final NoteService noteService;

    //Initialize calling the service functions
    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    // This is the post method to create new notes with required title and body parameter
    @PostMapping("/notes")
    @ResponseBody
    public ArrayList<HashMap<String, Object>> createNotes(@RequestParam(value = "title", required = true) String title,
                                                          @RequestParam(value = "body", required = true) String body ) {

        //used for error message return
        ArrayList<HashMap<String, Object>> errorList = new ArrayList<HashMap<String, Object>>();
        HashMap<String, Object> note1 = new HashMap<String, Object>();

        if(title.length() < 1){
            // Invalid title
            note1.put("error message", "Please enter Title");
            note1.put("Field", "title");
            errorList.add(note1);
            return errorList;
        }else if (body.length() < 1){
            // Invalid body
            note1.put("error message", "Please enter Body");
            note1.put("Field", "body");
            errorList.add(note1);
            return errorList;
        }else{
            // Passed validation
            return noteService.addNewNote(title, body);
        }
    }

    // This is the GET method of notes to get the array details for all notes
    @GetMapping("/notes")
    @ResponseBody
    public ArrayList<HashMap<String, Object>> getAllNotes() {
        ArrayList<HashMap<String, Object>> notes = noteService.getAllNotes();
        if(notes.size() == 0){
            ArrayList<HashMap<String, Object>> noteListValidation = new ArrayList<HashMap<String, Object>>();
            HashMap<String, Object> note1 = new HashMap<String, Object>();
            note1.put("Message", "No Notes yet please add new Notes!");
            noteListValidation.add(note1);
            return noteListValidation;
        }else {
            return notes;
        }
    }

    // This is the get method of notes to get the specific data using ID parameter
    @GetMapping("/notes/{ID}")
    @ResponseBody
    public ArrayList<HashMap<String, Object>> getSpecificNote(@PathVariable(value="ID") String id) {
        return noteService.getNoteById(id);
    }

    // This is the put method of notes to update the specific data using ID parameter
    @PutMapping("/notes/{ID}")
    @ResponseBody
    public ArrayList<HashMap<String, Object>> updatedSpecificNote(@PathVariable(value="ID") String id,
                                      @RequestParam(value = "title", required = true) String title,
                                      @RequestParam(value = "body", required = true) String body) {
        //used for error message return
        ArrayList<HashMap<String, Object>> errorList = new ArrayList<HashMap<String, Object>>();
        HashMap<String, Object> note1 = new HashMap<String, Object>();

        if(title.length() < 1){
            // Invalid title
            note1.put("error message", "Please enter Title");
            note1.put("Field", "title");
            errorList.add(note1);
            return errorList;
        }else if (body.length() < 1){
            // Invalid body
            note1.put("error message", "Please enter Body");
            note1.put("Field", "body");
            errorList.add(note1);
            return errorList;
        }else{
            // Passed validation
            return noteService.updateNote(id, title, body);
        }
    }

    // This is the Delete method of notes to delete the specific data using ID parameter on the array
    @DeleteMapping("/notes/{ID}")
    @ResponseBody
    public ArrayList<HashMap<String, Object>> deleteSpecificNote(@PathVariable(value="ID") String id){
        return noteService.deleteNoteById(id);
    }
}