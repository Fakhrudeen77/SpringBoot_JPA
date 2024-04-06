package com.example.jpa.dto;

import java.io.Serializable;

public class Story_Book_ManyToOneDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long storyId;
	private String storyName;
	private Book_Story_OneToManyDto book;
	
	public Story_Book_ManyToOneDto() {
		
	}
	public Long getStoryId() {
		return storyId;
	}
	public void setStoryId(Long storyId) {
		this.storyId = storyId;
	}
	public String getStoryName() {
		return storyName;
	}
	public void setStoryName(String storyName) {
		this.storyName = storyName;
	}
	public Book_Story_OneToManyDto getBook() {
		return book;
	}
	public void setBook(Book_Story_OneToManyDto book) {
		this.book = book;
	}
	
}
