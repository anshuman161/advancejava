package com.bridgelabz.fundooproject.utilmethods;

import java.util.Comparator;

import com.bridgelabz.fundooproject.model.NoteDetails;

public class NotesSorting implements Comparator<NoteDetails>
{
	@Override
	public int compare(NoteDetails n1, NoteDetails n2) 
	{	    
		return n1.getUpdatedTime().compareTo(n2.getUpdatedTime());
	}

}
