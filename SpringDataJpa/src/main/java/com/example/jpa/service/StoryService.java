package com.example.jpa.service;

import java.util.List;

import com.example.jpa.entity.Story;

public interface StoryService {
	public Story saveStory(Story story);
	public List<Story> getStoryList();

}
