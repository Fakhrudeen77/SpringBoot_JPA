package com.example.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jpa.entity.Book_Story_OneToMany;

public interface BookRepository extends JpaRepository<Book_Story_OneToMany, Long> {

}
