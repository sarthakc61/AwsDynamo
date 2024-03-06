package com.awsexample.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.awsexample.entity.Person;

@Repository
public class PersonRepository {
	
	@Autowired
	DynamoDBMapper dynamoDBMapper;

	
	public Person addPerson(Person person) {
		dynamoDBMapper.save(person);
		return person;
	}
	
	public Person findPersonByPersonId(String personId) {
		return dynamoDBMapper.load(Person.class, personId);
	}
	
	public String deletePerson(Person person) {
		dynamoDBMapper.delete(person);
		return "Person deleted successfully";
	}
	
	public String editPerson(Person person) {
		dynamoDBMapper.save(person, buildExpression(person));
		return "updated peron";
	}
	
	private DynamoDBSaveExpression buildExpression(Person person) {
		DynamoDBSaveExpression dynamoDBSaveExpression = new DynamoDBSaveExpression();
		Map<String, ExpectedAttributeValue> expectedMap = new HashMap<>();
		expectedMap.put("personId", new ExpectedAttributeValue(new AttributeValue().withS(person.getPersonId())));
		dynamoDBSaveExpression.setExpected(expectedMap);
		return dynamoDBSaveExpression;
	}
}
