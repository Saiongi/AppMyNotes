package com.mynotes.controller;


import java.util.List;


import com.mynotes.dao.NoteDAOImpl;
import com.mynotes.model.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/notes")
public class NoteController {

    @Autowired
    private NoteDAOImpl noteDAOImpl;

    /*** Creating a new Note ***/
    @RequestMapping(
        value="",
        method=RequestMethod.POST,
        produces="application/json", consumes="application/json"
    )
    public void createNote(@RequestBody Note note)
    {
        noteDAOImpl.createNote(note);
    }

    /*** Retrieve all Notes ***/
    @RequestMapping(
        value="/{page}/{offset}",
        produces="application/json",
        method=RequestMethod.GET
    )
    public List getNotesByPaging(
        @PathVariable("page") int page,
        @PathVariable("offset") int offset,
        @RequestParam(value = "filter", required = false) String filter,
        @RequestParam(value = "sort", required = false) String sort
    )
    {
        return noteDAOImpl.getNotesByPaging(page , offset, filter, sort);
    }

    /*** Update a Note ***/
    @RequestMapping(
        value="",
        method=RequestMethod.PUT,
        produces="application/json",
        consumes="application/json"
    )
    public void updateNote(@RequestBody Note note)
    {
        noteDAOImpl.updateNote(note);
    }

    /*** Delete a Note ***/
    @RequestMapping(
        value="/{id}",
        method = RequestMethod.DELETE,
        produces="application/json"
    )
    public void deleteNote(@PathVariable("id") long id)
    {
        noteDAOImpl.deleteNote(id);
    }

    /*** Update status isDone ***/
    @RequestMapping(
        value="/{id}",
        method = RequestMethod.PUT,
        produces="application/json"
    )
    public void setIsDone(
        @PathVariable("id") int id,
        @RequestParam("done") int done
    )
    {
        noteDAOImpl.setIsDone(id, done);
    }

    // Get amount notes
    @RequestMapping(
        value="/amount",
        produces="application/json",
        method=RequestMethod.GET
    )
    public int getSize(@RequestParam("filter") String filter){
        return noteDAOImpl.getSize(filter);
    }
}
