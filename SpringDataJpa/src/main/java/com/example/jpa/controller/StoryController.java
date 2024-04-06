package com.example.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.jpa.entity.Story;
import com.example.jpa.service.StoryService;

@RestController
@RequestMapping("/story")
public class StoryController {


	@Autowired
	private StoryService storyService;
	
	@PostMapping("/saveStory")
	public ResponseEntity<Story> saveStory(@RequestBody Story story){
				
		try {
			return new ResponseEntity<Story>(storyService.saveStory(story),HttpStatus.CREATED);
		}
		catch(Exception e) {
			return new ResponseEntity<Story>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@GetMapping("/getStoryList")
	public ResponseEntity<List<Story>> getStoryList(){
				
		try {
			return new ResponseEntity<List<Story>>(storyService.getStoryList(),HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
}
