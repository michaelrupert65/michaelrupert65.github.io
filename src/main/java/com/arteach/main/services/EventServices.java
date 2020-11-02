package com.arteach.main.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arteach.main.dao.IEventRepo;
import com.arteach.main.models.Event;



@Service
public class EventServices {

	@Autowired
	IEventRepo eventRepo;
	
	public List<Event>findAll(){
		
		return eventRepo.findAll();
		
	}
	
	public Event findById(Integer id) {

		return eventRepo.findById(id).get();

	}
	public boolean existsById(Integer id) {

		return eventRepo.existsById(id);
	}
	
	public void deleteById(Integer id) {

		if (existsById(id))
			eventRepo.deleteById(id);

	}
	public void save(Event event) {
		
		eventRepo.save(event);
	

	}
	
}
