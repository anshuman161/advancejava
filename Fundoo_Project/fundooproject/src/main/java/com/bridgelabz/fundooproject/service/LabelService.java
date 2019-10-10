package com.bridgelabz.fundooproject.service;

import com.bridgelabz.fundooproject.model.LabelDetails;

public interface LabelService {
	public void save(LabelDetails label, String token);

	public boolean delete(int labelId, String token);

	public boolean addNoteToLabel(long labelId, long noteId, String token);

	public boolean edit(int labelId, String token);
	
}
