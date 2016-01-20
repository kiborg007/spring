package com.roman.model;

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

@Entity
@Table(name="COORDINATES")
@XmlRootElement(name = "coordinates")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})  
public class Coordinates {

	@Id
	@Column(name="COORD_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int coordID ;
	
	private String latitude ;
	
	private String longitude ;
	
	private Person person ;


	@JsonProperty
	@XmlElement
	public int getCoordID() {
		return coordID;
	}

	public void setCoordID(int coordID) {
		this.coordID = coordID;
	}

	@JsonProperty
	@XmlElement
	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	@JsonProperty
	@XmlElement
	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	
	@XmlElement
	//@JsonBackReference
	//@JsonManagedReference
	@JsonProperty
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@Override
	public String toString() {
		return "Coordinates [coordID=" + coordID + ", latitude=" + latitude + ", longitude=" + longitude + "]";
	}

	
}
