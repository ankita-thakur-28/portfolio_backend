package com.codewithankita.portfolioproject.service;

import com.codewithankita.portfolioproject.model.Contact;
import com.codewithankita.portfolioproject.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
@Service
public class ContactService {
    @Autowired
    private ContactRepository contactRepository;

    public void addContact(Contact contact) {
        contactRepository.addContact(contact);

        System.out.println("Contact added successfully");
    }
}
