package com.bridgelabz.fundooproject.repository;

import java.time.LocalDateTime;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bridgelabz.fundooproject.model.NoteDetails;
import com.bridgelabz.fundooproject.model.NoteDto;
import com.bridgelabz.fundooproject.model.UserInformation;

@Repository
public class NoteRepositryImpl implements Note 
{
	@Autowired
	private EntityManager entity;

	@Override
	public boolean save(NoteDetails details) 
	{
		Session session = entity.unwrap(Session.class);
		session.save(details);
		return true;
	}
	@Override
	public UserInformation findById(long userId) 
	{
		Session session = entity.unwrap(Session.class);
		Query query = session.createQuery("from UserInformation where userId=:userId");
		query.setParameter("userId", userId);
		return  (UserInformation) query.uniqueResult();
	}
	
	@Override
	public NoteDetails updateNotes(NoteDetails details) 
	{
		Session session = entity.unwrap(Session.class);
		Query query=session.createQuery("update NoteDetails note set note.tittle='"+details.getTittle()+"',note.description='"+details.getDescription()+"',note.isPin='"+details.isTrash()+"',note.isArchieve='"+details.isArchieve()+"',note.isTrash='"+details.isPin()+"',note.updatedTime='"+LocalDateTime.now()+"' ");
		return (NoteDetails) query.uniqueResult();
	}
	@Override
	public NoteDetails findNoteById(long id) {
		Session session = entity.unwrap(Session.class);
		Query query = session.createQuery("from NoteDetails where noteId=:id");
		query.setParameter("id", id);
		return  (NoteDetails) query.uniqueResult();
	}
	@Override
	public int deleteNotes(Long id) 
	{
		Session session = entity.unwrap(Session.class);
		Query query = session.createQuery("delete from NoteDetails where noteId=:id");
		query.setParameter("id", id);
		return  query.executeUpdate();
		
	}
	@Override
	public int sortingNotes(Long id) 
	{
		Session session = entity.unwrap(Session.class);
		
		
	//	query.setParameter("id", id);
		return 0;//query.executeUpdate();
		
	}

}
