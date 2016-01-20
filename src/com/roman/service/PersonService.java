package com.roman.service;

import java.util.List;

import com.roman.model.Person;

public interface PersonService {

	public void addPerson(Person p);
	public void updatePerson(Person p);
	public List<Person> listPersons();
	public List<Person> getListPersons(); // It's temp !!!
	public Person getPersonById(int id);
	public void removePerson(int id);
	
}
