package com.aaronmorgan.events.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aaronmorgan.events.models.Event;
import com.aaronmorgan.events.models.Message;
import com.aaronmorgan.events.models.User;
import com.aaronmorgan.events.repositories.MessageRepository;


@Service
public class MessageService {
	@Autowired
	private MessageRepository mRepo;
	
	public MessageService(MessageRepository mRepo) {
		this.mRepo = mRepo;
	}
	
	
	//Create
	public Message createMessage(Message message) {
		return this.mRepo.save(message);
	}
	
	
	//Create Manually
	public void comment(User author, Event topic, String content) {
		this.mRepo.save(new Message(author, topic, content));
	}
}
