package com.example.jpa.entity;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="Story")
public class Story implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	
	private Long storyId;
	private String storyName;
	private Book book;

	public Story() {
		
	}
	public Story(Long storyId, String storyName, Book book) {
		super();
		this.storyId = storyId;
		this.storyName = storyName;
		this.book = book;
	}
	
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
	@JsonBackReference
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "Book_Id")
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}

}
