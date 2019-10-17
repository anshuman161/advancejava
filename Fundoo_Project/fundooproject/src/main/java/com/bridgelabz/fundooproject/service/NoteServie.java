package com.bridgelabz.fundooproject.service;

import java.util.List;

import com.bridgelabz.fundooproject.model.NoteDetails;
import com.bridgelabz.fundooproject.model.NoteDto;

public interface NoteServie {
public void save(NoteDto note,String token);

public void updateNotes(NoteDetails details, String token);

public long deleteNotes(long noteId, String token);

//public void sortNotes(NoteDetails notes, String token);

public List<NoteDetails> fetchAllNotes(String token);
}
