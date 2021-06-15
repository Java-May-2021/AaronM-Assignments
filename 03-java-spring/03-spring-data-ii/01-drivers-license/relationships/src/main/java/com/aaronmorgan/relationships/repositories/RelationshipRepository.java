package com.aaronmorgan.relationships.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.aaronmorgan.relationships.models.Person;

@Repository
public interface RelationshipRepository extends CrudRepository<Person, Long>{
	List<Person>findAll();
}
