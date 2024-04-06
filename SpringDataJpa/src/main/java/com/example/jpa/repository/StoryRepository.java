package com.example.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jpa.entity.Story;

public interface StoryRepository extends JpaRepository<Story, Long>{

}
