package com.aaronmorgan.relationships.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aaronmorgan.relationships.models.License;
import com.aaronmorgan.relationships.models.Person;
import com.aaronmorgan.relationships.repositories.LicenseRepository;
import com.aaronmorgan.relationships.repositories.PersonRepository;
import com.aaronmorgan.relationships.repositories.RelationshipRepository;
@Service
public class RelationshipService {
	private final PersonRepository pRepo;
	private final LicenseRepository lRepo;
	private final RelationshipRepository rRepo;
	public RelationshipService(RelationshipRepository repo, PersonRepository repoP, LicenseRepository repoL) {
		this.rRepo = repo;
		this.pRepo = repoP;
		this.lRepo = repoL;
	}
	
	//Display All
	public List<Person> getAllPeople(){
		return this.rRepo.findAll();
	}
	
	//Display One
	public Person getSinglePerson(Long id) {
		return this.rRepo.findById(id).orElse(null);
	}
	
	//Create
	public Person createPerson(Person person) {
		return this.rRepo.save(person);
	}
	
	//Create Manually
	public Person createPersonManually(String firstName, String lastName) {
		Person newPerson = new Person(firstName, lastName);
		return this.rRepo.save(newPerson);
	}
	
	//Update
	public Person updatePerson(Person person) {
		return this.rRepo.save(person);
	}
	
	//Delete
	public void deletePerson(Long id) {
		this.rRepo.deleteById(id);
	}
	
	public List<Person> UnlicensedPeople(){
		return pRepo.findByLicenseIdIsNull();
	}
	
    public License createLicense(License newLicense) {
    	newLicense.setNumber(this.makeLicenseNumber());
        return lRepo.save(newLicense);
    }
    public int makeLicenseNumber() {
    	License l = this.lRepo.findTopByOrderByNumberDesc();
    	if (l == null) {
    		return 1;	
    	}
    	int previousLicenseNumber = l.getNumber();
    	previousLicenseNumber++;
    	return (previousLicenseNumber);
    }
	public Person findPerson(Long id) {
		return this.rRepo.findById(id).orElse(null);
	}
}


