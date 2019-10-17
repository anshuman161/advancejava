package com.bridgelabz.fundooproject.repository;

import java.util.List;

import com.bridgelabz.fundooproject.model.NoteDetails;
import com.bridgelabz.fundooproject.model.UserInformation;

public interface Note {
 public void save(NoteDetails noteDetails);
 
public UserInformation findById(long tokenId);

public NoteDetails updateNotes(NoteDetails details);

public NoteDetails findNoteById(long noteId);

public int deleteNotes(Long id);

//public int sortingNotes(Long id);

public List<NoteDetails> fetchNotesByUserId(long id);
}
