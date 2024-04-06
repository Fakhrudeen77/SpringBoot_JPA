package com.example.jpa.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="Book")
public class Book implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	private Long bookId;
	private String bookName;
	private List<Story> storyList=new ArrayList<Story>();
	
	public Book() {
		
	}
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "Book_Id")
	public Long getBookId() {
		return bookId;
	}
	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}
	@Column(name = "Book_Name")
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	
	@JsonManagedReference
	@OneToMany(fetch = FetchType.EAGER, mappedBy="book", cascade = CascadeType.ALL)
	public List<Story> getStoryList() {
		return storyList;
	}
	public void setStoryList(List<Story> storyList) {
		
		this.storyList = storyList;
		
		for(Story story:storyList) {
			System.out.println(story.getStoryName());
			story.setBook(this);
			
		}
	}
	

}
