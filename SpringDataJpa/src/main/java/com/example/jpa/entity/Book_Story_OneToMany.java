package com.example.jpa.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="Book_Story_One2One")
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Book_Story_OneToMany implements Serializable {


	private static final long serialVersionUID = 1L;
	
	public Book_Story_OneToMany() {
		
	}
	
	private Long bookId;
	private String bookName;
	private List<Story_Book_ManyToOne> storyList;
	
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
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "book")
	//@JsonIgnoreProperties("book")
	
	@JsonIgnore
	
	@JsonManagedReference
	public List<Story_Book_ManyToOne> getStoryList() {
		return storyList;
	}
	public void setStoryList(List<Story_Book_ManyToOne> storyList) {
		this.storyList = storyList;
		
		/*for(Story_Book_ManyToOne story : storyList) {
			 System.out.println(story.getStoryName());
			 story.setBook(book);
		 }*/
		
		
		
		for(Story_Book_ManyToOne story: this.storyList) {
			story.setBook(this);
			
		}
	}
	
	
	
	
	
	
	
	
	

}
