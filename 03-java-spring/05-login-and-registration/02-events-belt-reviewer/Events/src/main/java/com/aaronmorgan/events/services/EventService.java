package com.aaronmorgan.events.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aaronmorgan.events.models.Event;
import com.aaronmorgan.events.models.User;
import com.aaronmorgan.events.repositories.EventRepository;

@Service
public class EventService {
	 private final EventRepository eRepo;
	    
	    public EventService(EventRepository eRepo) {
	        this.eRepo = eRepo;
	    }
	    
		//Display All
		public List<Event> getAllEvents(){
			return this.eRepo.findAll();
		}
		
		//Display One
		public Event getSingleEvent(Long id) {
			return this.eRepo.findById(id).orElse(null);
		}
		
		//Create
		public Event createEvent(Event event) {
			return this.eRepo.save(event);
		}
		
		// Delete
		public void deleteEvent(Long id) {
			this.eRepo.deleteById(id);
		}
		
		// Update
		public Event updateEvent(Event event) {
			return this.eRepo.save(event);
		}
		//Join Event
		public void joinEvent(User user, Event event) {
			List<User> attendees = event.getAttendees();
			attendees.add(user);
			this.eRepo.save(event);
		}
		//Unjoin Event
		public void unjoinEvent(User user, Event event) {
			List<User> attendees = event.getAttendees();
			attendees.remove(user);
			this.eRepo.save(event);
		}
		//In State
		 public List<Event> getEventsWithState(String state){
		    	return this.eRepo.findByState(state);
		    }
		 //Not In State
		//In State
		 public List<Event> getEventsNotWithState(String state){
		    	return this.eRepo.findByStateIsNot(state);
		    }
}
