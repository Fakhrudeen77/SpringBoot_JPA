package com.example.jpa.dto;

import java.io.Serializable;
import java.util.List;

import com.example.jpa.entity.Story_Book_ManyToOne;

public class Book_Story_OneToManyDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long bookId;
	private String bookName;	
	private List<Story_Book_ManyToOneDto> storyList;
	
	public Book_Story_OneToManyDto() {
		
	}
	
	public Long getBookId() {
		return bookId;
	}
	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public List<Story_Book_ManyToOneDto> getStoryList() {
		return storyList;
	}

	public void setStoryList(List<Story_Book_ManyToOneDto> storyList) {
		this.storyList = storyList;
	}

	
	
}
