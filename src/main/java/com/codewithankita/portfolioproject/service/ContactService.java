package com.codewithankita.portfolioproject.service;
import com.codewithankita.portfolioproject.model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class ContactService {

//    @Autowired
//    private ContactRepository contactRepository;

    @Autowired
    private EmailService emailService;

    public void addContact(Contact contact) {
//        contactRepository.addContact(contact);
        emailService.sendContactEmail(
                contact.getName(),
                contact.getEmail(),
                contact.getMessage()
        );
        System.out.println("Contact added successfully");
    }
}
