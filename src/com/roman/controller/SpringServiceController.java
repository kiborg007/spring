package com.roman.controller;

//import org.apache.log4j.Logger;

import java.util.List;

import org.apache.log4j.Logger;
/*import org.slf4j.Logger;
import org.slf4j.LoggerFactory;*/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.roman.model.Person;
import com.roman.service.PersonService;

@RestController
@RequestMapping("/rest/service")
public class SpringServiceController {
	
	private static final Logger logger = Logger.getLogger(SpringServiceController.class);
	
	private PersonService personService;
	
	
	@Autowired(required=true)
	@Qualifier(value="personService")
	public void setPersonService(PersonService ps){
		this.personService = ps;
	}
	
	@RequestMapping(value = "/greeting/{name}", method = RequestMethod.GET)
	public String getGreeting(@PathVariable String name) {
		String result = "Hello " + name;
		logger.info("======= Greeting !!! =======");
		return result;
	}
	
	@RequestMapping(value = "/getPerson/{id}", method = RequestMethod.GET, produces = "application/json") 
	public @ResponseBody Person getPerson(@PathVariable("id") int id){
		Person person = personService.getPersonById(id);
		logger.info("======= Person - "+person.toString()+" =======");
		return person ;
	}
	
	@RequestMapping(value = "/getAllPersons", method = RequestMethod.GET, produces = "application/json") 
	public @ResponseBody List<Person> getAllPersons(){
		return personService.listPersons();
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)  
	public void addPerson(@RequestBody Person person){
		try{
			personService.addPerson(person);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
