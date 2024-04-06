package com.example.jpa.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jpa.entity.Story;
import com.example.jpa.repository.StoryRepository;

@Service
public class StoryServiceImpl implements StoryService{

	@Autowired
	private StoryRepository storyRepository;
	
	@Override
	public Story saveStory(Story story) {
		// TODO Auto-generated method stub
		return storyRepository.saveAndFlush(story);
	}

	@Override
	public List<Story> getStoryList() {
		// TODO Auto-generated method stub
		return storyRepository.findAll();
	}

}
