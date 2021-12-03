package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.model.Contact;
import com.example.demo.repository.ContactRepository;

import net.bytebuddy.asm.Advice.This;

@SpringBootApplication
public class ContactApplicationSpringApplication implements CommandLineRunner {
	
	@Autowired
	private ContactRepository contactRepository;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	public static void main(String[] args) {
		SpringApplication.run(ContactApplicationSpringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		contactRepository.save(new Contact("ram","98874534586","img1.png","abc@gmail.com"));
		contactRepository.save(new Contact("Shyam","879583473","img2.png","xyz@gmail.com"));
		contactRepository.save(new Contact("Sita","7845365636","img3.png","klm@gmail.com"));
		contactRepository.save(new Contact("Dom","9000232423","img4.png","jkl@gmail.com"));
		
	}

}
