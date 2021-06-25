package com.aaronmorgan.events.repositories;


import org.springframework.data.repository.CrudRepository;

import com.aaronmorgan.events.models.Message;



public interface MessageRepository extends CrudRepository<Message, Long>{

}
