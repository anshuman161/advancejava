package com.bridgelabz.fundooproject.service;

import com.bridgelabz.fundooproject.model.NoteDetails;
import com.bridgelabz.fundooproject.model.NoteDto;

public interface NoteServie {
public void save(NoteDto note,String token);

public void updateNotes(NoteDto details, Long id, String token);

public int deleteNotes(Long id, String token);

public void sortNotes(NoteDetails notes, String token);
}
