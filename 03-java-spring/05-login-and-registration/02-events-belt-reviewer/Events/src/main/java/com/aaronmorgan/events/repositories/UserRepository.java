package com.aaronmorgan.events.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.aaronmorgan.events.models.User;



@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findByEmail(String email);

}
