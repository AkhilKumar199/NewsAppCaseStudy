// Importing package module to code fragment
package com.cg.services;
//Importing required classes
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.model.Contact;
import com.cg.repository.ContactRepository;




//Annotation
@Service
//Class
public class ContactService {

	@Autowired
	private ContactRepository contactrepository;
	

	public Contact addContact (Contact contact) {
		return contactrepository.save(contact);
	}
// Read operation
	public List<Contact> getContact() {
		List<Contact> contact = contactrepository.findAll();
		System.out.println("Getting data from DB : " + contact);
		return contact;
	}

	public Optional<Contact> getContactbyId(String id) {
		return contactrepository.findById(id);
	}
// Delete operation
	public void deleteContact(Contact contact) {
		contactrepository.delete(contact);
	}


}
