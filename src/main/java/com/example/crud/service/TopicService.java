package com.example.crud.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.crud.model.Topic;

@Service
public class TopicService {

    private List<Topic> topicList = new ArrayList<>(Arrays.asList(

            new Topic("1", "Spring boot", "Spring Description"),
            new Topic("2", "Spring FrameWork", "Thymeleaf Description"),
            new Topic("3", "Java FrameWork", "Java Description")

    ));
    
    public List<Topic> getAllTopicList(){
    	return topicList;
    }

	/*
	 * public Topic getTopic(String id) {
	 * 
	 * return topicList.stream().filter(topic ->
	 * topic.getId().equals(id)).findFirst().get(); }
	 */
	
	public void addTopic(Topic topic) {
		topicList.add(topic);
	}
	public void updateTopic (Topic topic, String id) {
		int counter = 0;
		for(Topic topic1 : topicList) {
			if(topic1.getId().equals(id)) {
				topicList.set(counter, topic);
			}
			counter++;
		}
		
	}
	public void deleteTopic(String id) {
		topicList.removeIf(topic -> topic.getId().equals(id));
	}

}
