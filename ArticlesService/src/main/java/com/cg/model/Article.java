// Importing package in this code module
package com.cg.model;

//Importing required classes
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "article")
public class Article {
	
	//Attributes
	@Id //Primary Key
	public String id;
	public String name;
	public String author;
	public String title;
	public String description;
	
	//Default Constructor
	public Article() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//Parameterized Constructor

	public Article(String id, String name, String author, String title, String description) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
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
		return "Article [id=" + id + ", name=" + name + ", author=" + author + ", title=" + title + ", description="
				+ description + "]";
	}
	
	
	
	
	
	
	

}
