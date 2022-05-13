package com.cg.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "technology")
public class Technology {
	
	//Attributes
	
	@Id //Primary Key
	
	public String id;
	public String title;
	public String description;
	
	//Default Constructor
	
	public Technology() {
		
		super();
		
	}
	
	//Parameterized Constructor

	public Technology(String id, String title, String description) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
	}
	
	//getters and setters

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	//toString method

	@Override
	public String toString() {
		return "Technology [id=" + id + ", title=" + title + ", description=" + description + "]";
	}
}

	
	
	
	
	