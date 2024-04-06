package com.example.jpa.service;

import java.util.List;

import com.example.jpa.dto.BookDto;
import com.example.jpa.dto.Book_Story_OneToManyDto;
import com.example.jpa.entity.Book;

public interface BookService {
	
	public Book saveBook(Book book);
	
	public Book_Story_OneToManyDto saveBookOneToMany(Book_Story_OneToManyDto  book);
	public List<Book> getBokList();
	public BookDto getBook(Long bookId);


}
