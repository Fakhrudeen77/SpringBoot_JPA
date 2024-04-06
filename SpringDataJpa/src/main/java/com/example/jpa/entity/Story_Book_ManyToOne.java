package com.example.jpa.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Story_Book_One2One")
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Story_Book_ManyToOne implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	public Story_Book_ManyToOne() {
		
	}
		
	private Long storyId;
	private String storyName;
	private Book_Story_OneToMany book;
    
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "Story_Id") 
	public Long getStoryId() {
		return storyId;
	}
	public void setStoryId(Long storyId) {
		this.storyId = storyId;
	}
	@Column(name = "Story_Name")
	public String getStoryName() {
		return storyName;
	}
	public void setStoryName(String storyName) {
		this.storyName = storyName;
	}
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Book_Id",referencedColumnName="Book_Id")
	//@JsonIgnoreProperties("storyList")
	@JsonIgnore
	@JsonBackReference
	public Book_Story_OneToMany getBook() {
		return book;
	}
	public void setBook(Book_Story_OneToMany book) {
		this.book = book;
	}
	

}
