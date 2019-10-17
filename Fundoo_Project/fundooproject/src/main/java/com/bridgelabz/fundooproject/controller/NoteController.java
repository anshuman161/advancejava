package com.bridgelabz.fundooproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.fundooproject.model.LabelDetails;
import com.bridgelabz.fundooproject.model.NoteDetails;
import com.bridgelabz.fundooproject.model.NoteDto;
import com.bridgelabz.fundooproject.service.NoteServie;
import com.bridgelabz.fundooproject.utilmethods.Response;
import com.bridgelabz.fundooproject.utilmethods.Utility;
@CrossOrigin(allowedHeaders = "*", origins = "*", exposedHeaders = { "jwtToken" })
@RestController
@RequestMapping("/notes")
public class NoteController
{
 @Autowired
 private NoteServie servie;

    @PostMapping("/creation")
	public ResponseEntity<Response> saveNote(@RequestBody NoteDto note, @RequestHeader ("token") String token)
	{    
    	System.out.println("inside the note api");
		servie.save(note,token);	
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(new Response("Note Saved successfully", 200, note));	
	}

    @PostMapping("/updation")
    public ResponseEntity<Response> updateNote(@RequestBody NoteDetails note, @RequestHeader ("token") String token)
    {
    	System.out.println("inside note update controller"+note.getDescription()+note.getNoteId());
          servie.updateNotes(note, token);
    	 return ResponseEntity.status(HttpStatus.ACCEPTED).body(new Response("Note Updated successfully", 200, token));
    }
    
    @DeleteMapping("/deletion")
    public ResponseEntity<Response> deleteNote(@RequestParam long noteId, @RequestHeader String token)
    {
     long notesId=servie.deleteNotes(noteId, token);
   	 return ResponseEntity.status(HttpStatus.ACCEPTED).body(new Response("Note deleted successfully", 200, notesId ));
	}
    
    @GetMapping("/fetchallnotes")
	public ResponseEntity<Response> FetchNotes( @RequestHeader String token)
	{
		List<NoteDetails>	noteslist=servie.fetchAllNotes(token);
		return ResponseEntity.status(HttpStatus.OK).body(new Response("Notes  are", 200,noteslist));
	      
	}
	/*
	 * @PostMapping("/sortingNotes") public ResponseEntity<Response>
	 * sortNotes(@RequestBody NoteDetails notes, @RequestHeader String token) {
	 * servie.sortNotes(notes, token); return
	 * ResponseEntity.status(HttpStatus.ACCEPTED).body(new
	 * Response("Note sort successfully", 200, notes)); }
	 */
    
}
