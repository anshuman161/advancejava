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
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "label_list")
public class LabelDetails 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long labelId;
	private String labelName;
	private long userId;

	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name = "Labels_Notes", 
    joinColumns = { @JoinColumn(name = "labelId") }, 
    inverseJoinColumns = { @JoinColumn(name = "noteId") })
	private List<NoteDetails> notes;


	public long getLabelId() {
		return labelId;
	}


	public void setLabelId(long labelId) {
		this.labelId = labelId;
	}


	public String getLabelName() {
		return labelName;
	}


	public void setLabelName(String labelName) {
		this.labelName = labelName;
	}


	public long getUserId() {
		return userId;
	}


	public void setUserId(long userId) {
		this.userId = userId;
	}


	public List<NoteDetails> getNotes() {
		return notes;
	}


	public void setNotes(List<NoteDetails> notes) {
		this.notes = notes;
	}

	
	
}
