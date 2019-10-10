package com.bridgelabz.fundooproject.repository;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bridgelabz.fundooproject.model.LabelDetails;
import com.bridgelabz.fundooproject.model.NoteDetails;
import com.bridgelabz.fundooproject.model.UserInformation;

@Repository
public class LabelRepositryImpl implements Label
{
@Autowired
EntityManager entity;

@Override
public UserInformation findById(long userId) 
{
	Session session = entity.unwrap(Session.class);
	Query query = session.createQuery("from UserInformation where userId=:userId");
	query.setParameter("userId", userId);
	return  (UserInformation) query.uniqueResult();
}


	@Override
	public void save(LabelDetails label)
	{
		Session session = entity.unwrap(Session.class);
		session.save(label);
	}
	
	

	
	@Override
	public NoteDetails findNoteById(long id) 
	{
	  NoteDetails demo= (NoteDetails) entity.unwrap(Session.class).createQuery("from NoteDetails where noteId='"+id+"'").uniqueResult();
		return demo;
		
	}
	@Override
	public LabelDetails fetchLabelByName(String labelName) 
	{
		Session session=entity.unwrap(Session.class);
		Query query=session.createQuery("from LabelDetails where labelName='"+labelName+"'");
		return  (LabelDetails) query.uniqueResult();
	}
	@Override
	public int deleteLabel(int labelId) 
	{
		return entity.unwrap(Session.class).createQuery("from LabelDetails where labelId='"+labelId+"'").executeUpdate();
		
	}
	@Override
	public int editLabel(int labelId) {
		return entity.unwrap(Session.class).createQuery("delete from LabelDetails where labelId='"+labelId+"'").executeUpdate();
	
	}


	@Override
	public LabelDetails findLabelById(long labelId) {
		LabelDetails details= (LabelDetails) entity.unwrap(Session.class).createQuery("from LabelDetails where labelId='"+labelId+"'").uniqueResult();
	      return details;
	}
	
  
}
