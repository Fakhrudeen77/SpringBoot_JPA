package com.example.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jpa.dto.BookDto;
import com.example.jpa.dto.Book_Story_OneToManyDto;
import com.example.jpa.entity.Book;
import com.example.jpa.exception.BookNotFoundException;
import com.example.jpa.service.BookService;

@RestController
@RequestMapping("/book")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@PostMapping("/saveBook")
	public ResponseEntity<Book> saveBook(@RequestBody Book book){
				
		try {
			return new ResponseEntity<Book>(bookService.saveBook(book),HttpStatus.CREATED);
		}
		catch(Exception e) {
			return new ResponseEntity<Book>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@PostMapping("/saveBookOneToMany")
	public ResponseEntity<Book_Story_OneToManyDto> saveBookOneToMany(@RequestBody Book_Story_OneToManyDto  bookDto){
		
		System.out.println("SaveBook"+" "+bookDto.getBookName()+" "+bookDto.getStoryList().size());
		
				
		try {
			return new ResponseEntity<Book_Story_OneToManyDto>(bookService.saveBookOneToMany(bookDto),HttpStatus.CREATED);
		}
		catch(Exception e) {
			return new ResponseEntity<Book_Story_OneToManyDto>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@GetMapping("/getBookList")
	public ResponseEntity<List<Book>> getBookList(){
				
		try {
			return new ResponseEntity<List<Book>>(bookService.getBokList(),HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	
	

	@GetMapping("/test")
	public String test() {
				
		return "Welcome to Spring Boot";
		
	}
	
	 @GetMapping("getBook/{bookId}")
	    public BookDto getBook(@PathVariable("bookId") Long bookId) {

	        // Retrieve the book from the database
	        BookDto book = bookService.getBook(bookId);

	        // If the book does not exist, throw BookNotFoundException
	        if (null == book) {
	            throw new BookNotFoundException("Book with ID " + bookId + " not found");
	        }

	        return book;

	    }
	
	
}
