package com.example.jpa.service;

import java.util.List;
import java.util.Objects;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jpa.dto.BookDto;
import com.example.jpa.dto.Book_Story_OneToManyDto;
import com.example.jpa.entity.Book;
import com.example.jpa.entity.Book_Story_OneToMany;
import com.example.jpa.entity.Story_Book_ManyToOne;
import com.example.jpa.mapper.OrikaBeanMapper;
import com.example.jpa.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService{

	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private OrikaBeanMapper mapper;
	
	
	@Override
	@Transactional
	public Book saveBook(Book book) {
		//return bookRepository.saveAndFlush(book);
		return null;
		
	}
	@Override
	public List<Book> getBokList() {
		// TODO Auto-generated method stub
		//return bookRepository.findAll();
		return null;
	}
	@Override
	public BookDto getBook(Long bookId) {
		 return bookRepo().stream()
	                .filter(e -> Objects.equals(e.getBookId(), bookId))
	                .findFirst()
	                .orElse(null);
	}
	
	
	
	private List<BookDto> bookRepo() {

       /*return List.of(
                new BookDto(1L, "C", "Fakhrudeen"),
                new BookDto(2L, "C++", "Rehana"),
                new BookDto(3L, "Head First Java", "Kathy Sierra"),
                new BookDto(4L, "Rich Dad Poor Dad", "Robert Kiyosaki")
        );*/
		return null;
    }
	@Override
	@Transactional
	public Book_Story_OneToManyDto saveBookOneToMany(Book_Story_OneToManyDto bookDto) {
		
		System.out.println("SaveBook----Service"+" "+bookDto.getBookName()+" "+bookDto.getStoryList().size());
		
		Book_Story_OneToMany book=mapper.map(bookDto, Book_Story_OneToMany.class);
		
		List<Story_Book_ManyToOne> storyList=book.getStoryList();
		System.out.println("Story List Size"+" "+storyList.size());
		
		 
		 System.out.println("Book Detail");
		 System.out.println("Book Name"+" "+book.getBookName());
		 /*for(Story_Book_ManyToOne story : storyList) {
			 System.out.println(story.getStoryName());
			 story.setBook(book);
		 }*/
		
		book= bookRepository.saveAndFlush(book);
		
		
		
		Book_Story_OneToManyDto bookDto1  = mapper.map(book, Book_Story_OneToManyDto.class);
		return bookDto1;
		  
		
		
	}
	
	

}
