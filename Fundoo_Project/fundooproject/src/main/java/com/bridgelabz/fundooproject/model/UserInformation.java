package com.bridgelabz.fundooproject.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.SortComparator;
import org.springframework.stereotype.Component;

import com.bridgelabz.fundooproject.utilmethods.NotesSorting;

@Component
@Entity
@Table(name = "user_details")
public class UserInformation
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long userId;
	private String username;
	private String email;
	private long phoneno;
	private String address;
	private String password;
	private boolean isVerified;	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(long phoneno) {
		this.phoneno = phoneno;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean isVerified() 
	{
		return isVerified;
	}
	public void setVerified(boolean isVerified) 
	{
		this.isVerified = isVerified;
	}

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "userId")
	private List<NoteDetails> note ;

	public List<NoteDetails> getNote() 
	{
		return note;
	}
	public void setNote(List<NoteDetails> note) 
	{
		this.note = note;
	}

	
}
