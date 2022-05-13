package com.cg.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "lifestyle")
public class LifeStyle {
	
	//Attributes
	@Id //Primary Key
	public String id;
	public String category;
	public String name;
	
	//Default Constructor
	public LifeStyle() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//Parameterized Constructor

	public LifeStyle(String id, String category, String name) {
		super();
		this.id = id;
		this.category = category;
		this.name = name;
	}
	
	//getters and setters

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	//toString method

	@Override
	public String toString() {
		return "LifeStyle [id=" + id + ", category=" + category + ", name=" + name + "]";
	}
}
	
	
	
	
	
	
	