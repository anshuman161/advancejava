package com.bridgelabz.fundooproject.repository;

import com.bridgelabz.fundooproject.model.NoteDetails;
import com.bridgelabz.fundooproject.model.NoteDto;
import com.bridgelabz.fundooproject.model.UserInformation;

public interface Note {
 public boolean save(NoteDetails noteDetails);

public UserInformation findById(long tokenId);

public NoteDetails updateNotes(NoteDetails details);

public NoteDetails findNoteById(long noteId);

public int deleteNotes(Long id);

public int sortingNotes(Long id);
}
