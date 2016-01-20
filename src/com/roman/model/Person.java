package com.roman.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

//import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * Entity bean with JPA annotations
 * Hibernate provides JPA implementation
 * @author pankaj
 *
 */
@Entity
@Table(name="PERSON")
@XmlRootElement(name = "person")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})  
public class Person {
 
	@Id
	@Column(name="PERSON_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int personID;
	
	private String name;
	
	private String country;
	
	/*private Set<Coordinates> coordinates = 
			new HashSet<Coordinates>(0);*/

	
	@JsonProperty
	@XmlElement
	public int getPersonID() {
		return personID;
	}

	public void setPersonID(int personID) {
		this.personID = personID;
	}

	@JsonProperty
	@XmlElement
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty
	@XmlElement
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	

/*	//@JsonProperty
	@XmlElement
	//@JsonManagedReference
	@JsonBackReference
	public Set<Coordinates> getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(Set<Coordinates> coordinates) {
		this.coordinates = coordinates;
	}*/

	@Override
	public String toString() {
		return "Person [personID=" + personID + ", name=" + name + ", country=" + country + "]";
	}
	
	
}
