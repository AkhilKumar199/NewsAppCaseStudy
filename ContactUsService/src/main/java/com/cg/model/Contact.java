// Importing package in this code module
package com.cg.model;
//Importing required classes
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
//POJO class
@Data
@AllArgsConstructor
@Document(collection = "Contacts")

public class Contact {
	//Attributes

   @Id //Primary Key
   private String id;
   
   private String name;
   
   private String email;

//Default Constructor
public Contact() {
	super();
	// TODO Auto-generated constructor stub
}
//Parameterized Constructor
public Contact(String id, String name, String email) {
	super();
	this.id = id;
	this.name = name;
	this.email = email;
}
	//getters and setters

public String getId() {
	return id;
}

public void setId(String id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}
	
//toString method

@Override
public String toString() {
	return "Contact [id=" + id + ", name=" + name + ", email=" + email + "]";
}
   
}
