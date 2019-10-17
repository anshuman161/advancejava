package com.bridgelabz.fundooproject.service;

import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.fundooproject.exception.UserException;
import com.bridgelabz.fundooproject.model.NoteDetails;
import com.bridgelabz.fundooproject.model.NoteDto;
import com.bridgelabz.fundooproject.model.UserInformation;
import com.bridgelabz.fundooproject.repository.Note;
import com.bridgelabz.fundooproject.utilmethods.Utility;

@Service
public class NoteServiceImpl implements NoteServie 
{
@Autowired
private Note noteRepositry;

@Autowired
private Utility utils;

@Autowired
ModelMapper mapper;

public UserInformation generatingToken(String token) {
	 long id=(long)utils.parseToken(token);
     UserInformation user =noteRepositry.findById(id);
     return user;
}

    @Transactional
	@Override
	public void save(NoteDto note, String token) 
	{ 
    	long id=(long)utils.parseToken(token);
    	 UserInformation user =noteRepositry.findById(id);
         if (user!=null)
         { 
    	 NoteDetails noteDetails=  mapper.map(note, NoteDetails.class);
		 noteDetails.setCreatedTime(LocalDateTime.now());
		 noteDetails.setUpdatedTime(LocalDateTime.now());
		 noteDetails.setPin(false);
		 noteDetails.setArchieve(false);
		 noteDetails.setTrash(false);
	     user.getNote().add(noteDetails);   
		  noteRepositry.save(noteDetails);
         }
         else 
         {
        	 throw new UserException("User Not Exist");
		 }
	}
    @Transactional
	@Override
	public void updateNotes(NoteDetails information, String token) 
	{
    	try {

			UserInformation user= noteRepositry.findById(utils.parseToken(token));

			NoteDetails note = noteRepositry.findNoteById(information.getNoteId());
			if (note != null) {
				System.out.println("note is   " + note);
				note.setNoteId(information.getNoteId());
				note.setDescription(information.getDescription());
				note.setTittle(information.getTittle());
				note.setPin(information.isPin());
				note.setArchieve(information.isArchieve());
				note.setTrash(information.isTrash());
				note.setUpdatedTime(LocalDateTime.now());
				noteRepositry.save(note);
			} else {
				throw new UserException("note is not present");
			}

		} catch (Exception e) {
			throw new UserException("user is not present");
		}
		
	}
    @Transactional
	@Override
	public long deleteNotes(long noteId, String token) 
    {
	   
	   long demo=0;
	   if(generatingToken(token)!=null)
	   {   
	   NoteDetails noteDetails=noteRepositry.findNoteById(noteId);
	   if (noteDetails!=null)
	   {
		   System.out.println("inside if block...");
		  demo=noteRepositry.deleteNotes(noteDetails.getNoteId());
		  return demo;
	   }
	   else 
	   {
		   throw new UserException("Note is Not Exist");
	   }
	   }
	return demo;
	}
    @Transactional
    @Override
	public List<NoteDetails> fetchAllNotes(String token) 
    {
    	return noteRepositry.fetchNotesByUserId(utils.parseToken(token));	
	}
	/*
	 * @Override public void sortNotes(NoteDetails notes, String token) {
	 * 
	 * if (generatingToken(token)!=null) {
	 * 
	 * // UserRepositry.
	 * 
	 * 
	 * } else { throw new UserException("User is Not Exist"); }
	 * 
	 * }
	 */

	
 
}
