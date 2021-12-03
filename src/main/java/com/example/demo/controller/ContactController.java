package com.example.demo.controller;

import java.util.HashMap;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Contact;
import com.example.demo.repository.ContactRepository;

@RestController
public class ContactController {

	@Autowired
	private ContactRepository contactRepository;

	@GetMapping("/getAllContacts")
	public List<Contact> getAllContacts() {
		return contactRepository.findAll();
	}

	@GetMapping("/findcontacts/{id}")
	public ResponseEntity<Contact> getContactById(@PathVariable(value = "id") Long contactId)
			throws ResourceNotFoundException {
		Contact contact = contactRepository.findById(contactId)
				.orElseThrow(() -> new ResourceNotFoundException("Contact not found for this id :: " + contactId));
		return ResponseEntity.ok().body(contact);
	}

	@PostMapping("/createcontacts")
	public Contact createContact(@Valid @RequestBody Contact contact) {
		return contactRepository.save(contact);
	}

	@PutMapping("/contacts/{id}")
	public ResponseEntity<Contact> updateContact(@PathVariable(value = "id") Long contactId,
			@Valid @RequestBody Contact contactDetails) throws ResourceNotFoundException {
		Contact c = contactRepository.findById(contactId)
				.orElseThrow(() -> new ResourceNotFoundException("Contact not found for this id :: " + contactId));

		c.setEmail(contactDetails.getEmail());
		c.setImageUrl(contactDetails.getImageUrl());
		c.setName(contactDetails.getName());
		c.setPhNumber(contactDetails.getPhNumber());
		final Contact updatedContact = contactRepository.save(c);
		return ResponseEntity.ok(updatedContact);
	}

	@DeleteMapping("/deletecontacts/{id}")
	public Map<String, Boolean> deleteContact(@PathVariable(value = "id") Long contactId)
			throws ResourceNotFoundException {
		Contact contact = contactRepository.findById(contactId)
				.orElseThrow(() -> new ResourceNotFoundException("Contact not found for this id :: " + contactId));

		contactRepository.delete(contact);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

	
}
