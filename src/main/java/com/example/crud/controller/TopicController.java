package com.example.crud.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.crud.model.Topic;
import com.example.crud.service.TopicService;



@Controller("/home")

public class TopicController {

	@Autowired
	private TopicService topicService;

	@GetMapping("/home")
	public ModelAndView getAllTopicList(){

		ModelAndView modelandview = new ModelAndView("index");
		List<Topic> topicList= topicService.getAllTopicList();
		modelandview.addObject("topicList",topicList);
		return modelandview;
		
		
	}


	@GetMapping("/addTopics")
	public ModelAndView addTopic (){
		ModelAndView modelandview = new ModelAndView("create_topic");
		Topic topic = new Topic(); 
		modelandview.addObject("topic", topic);
		return modelandview;
	}
	@PostMapping("/create")
	public ModelAndView createTopic (Topic topic){
		
		ModelAndView modelandview = new ModelAndView("index");
		System.out.println(topic);
		return modelandview;
	}
	@GetMapping("/updateTopic/{id}")
	
	public ModelAndView updateTopic(@PathVariable("id") String id) {
		ModelAndView modelandview = new ModelAndView("update_topic");
		Topic topic = new Topic();
		modelandview.addObject("topic", topic);
		return modelandview;
	}
	@PostMapping("/updateTopic/{id}")
	public ModelAndView updateTopic(@PathVariable("id") String id , Topic topic){
		
		ModelAndView modelandview = new ModelAndView("index");
		System.out.println(topic);
		return modelandview;
	}
	
	
	
	@GetMapping("/deleteTopic/{id}")

	public ModelAndView deleteTopic(@PathVariable("id") String id) {
		topicService.deleteTopic(id);
		ModelAndView modelandview = new ModelAndView("redirect:/home");
		return modelandview;
	}

}


