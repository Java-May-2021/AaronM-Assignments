package com.aaronmorgan.relationships.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.aaronmorgan.relationships.models.Person;

public interface PersonRepository extends CrudRepository<Person, Long> {
	List<Person> findByLicenseIdIsNull();
}
