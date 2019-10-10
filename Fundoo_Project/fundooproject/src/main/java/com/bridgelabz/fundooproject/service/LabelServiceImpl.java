package com.bridgelabz.fundooproject.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.fundooproject.exception.UserException;
import com.bridgelabz.fundooproject.model.LabelDetails;
import com.bridgelabz.fundooproject.model.NoteDetails;
import com.bridgelabz.fundooproject.model.UserInformation;
import com.bridgelabz.fundooproject.repository.Label;
import com.bridgelabz.fundooproject.utilmethods.Utility;

@Service
public class LabelServiceImpl implements LabelService {
	@Autowired
	private Label labelRepositry;

	@Autowired
	private Utility utils;
	
	public UserInformation generatingToken(String token)
	{
		long id = utils.parseToken(token);
		UserInformation userInformation = labelRepositry.findById(id);
		return userInformation;
	}

	@Transactional
	@Override
	public void save(LabelDetails label, String token) 
	{  
		long id = utils.parseToken(token);
		UserInformation userInformation = labelRepositry.findById(id);
		
		LabelDetails labelDemo=labelRepositry.fetchLabelByName(label.getLabelName());		
		     
		if (userInformation != null && labelDemo==null) 
		{
			label.setUserId(id);
			labelRepositry.save(label);
		}
		else 
		{
			throw new UserException("Duplicate label is not allowed");
		}

	}
   @Transactional 
	@Override
	public boolean delete(int labelId, String token) 
   {
	
		if (generatingToken(token) != null) 
		{
			int demo=labelRepositry.deleteLabel(labelId);
                  if (demo>0)
                  {
					return true;
				  }
                  else 
                  {
                	  throw new UserException("Delete Query is note executed"); 
				  }
		}
		else 
		{
			throw new UserException("User not exist"); 
		}
	}
	

    @Transactional
	@Override
	public boolean addNoteToLabel(long labelId, long noteId, String token) 
    {
		if (generatingToken(token) !=null) 
		{      
		    NoteDetails note= labelRepositry.findNoteById(noteId);
			 LabelDetails label=labelRepositry.findLabelById(labelId);
		    label.getNotes().add(note);
		       labelRepositry.save(label);
		} 
		else
		{
			throw new UserException("null is showing");
		}
		return false;
	}
@Override
public boolean edit(int labelId, String token) 
{
	
	if (generatingToken(token) !=null)
	{
	  int demo=labelRepositry.editLabel(labelId);
	  if (demo>0)
	  {
	      return true;	
	  }
	  else 
	  {
		  throw new UserException("Label not fetched");
	  }
	}
	else {
		throw new UserException("User not exist");
	}
}
	 
	
}
