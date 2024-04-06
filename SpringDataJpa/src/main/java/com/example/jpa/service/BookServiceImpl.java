package com.example.jpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jpa.mapper.OrikaBeanMapper;
import com.example.jpa.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService{

	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private OrikaBeanMapper mapper;
	
	
	
		  
		
		
	
	
	

}
