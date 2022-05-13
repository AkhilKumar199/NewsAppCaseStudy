package com.cg.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Document(collection = "Contacts")

public class Contact {

   @Id
   private String id;
   
   private String name;
   
   private String email;

public Contact() {
	super();
	// TODO Auto-generated constructor stub
}

public Contact(String id, String name, String email) {
	super();
	this.id = id;
	this.name = name;
	this.email = email;
}

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

@Override
public String toString() {
	return "Contact [id=" + id + ", name=" + name + ", email=" + email + "]";
}
   
}