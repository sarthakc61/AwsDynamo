package com.awsexample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.awsexample.entity.Person;
import com.awsexample.repository.PersonRepository;

@RestController
public class DynamoController {
	
	@Autowired
	private PersonRepository personRepository;
	
	@PostMapping("/savePerson")
	public Person savePerson(@RequestBody Person person) {
		return personRepository.addPerson(person);
	}
	
	@GetMapping("/getPerson/{personId}")
	public Person getPerson(@PathVariable String personId) {
		return personRepository.findPersonByPersonId(personId);
	}
	
	@DeleteMapping("/deletePerson")
	public String deletePerson(@RequestBody Person person) {
		return personRepository.deletePerson(person);
		
	}
	@PutMapping("/updatePerson")
	public String editPerson(@RequestBody Person person) {
		return personRepository.editPerson(person);
	}

}
