package com.codewithankita.portfolioproject.controller;

import com.codewithankita.portfolioproject.model.Contact;
import com.codewithankita.portfolioproject.response.ApiResponse;
import com.codewithankita.portfolioproject.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @PostMapping("/add-contact")
    public ApiResponse addContact(@RequestBody Contact contact) {
        contactService.addContact(contact);

        return new  ApiResponse("Contact details added successfully", 200 );
    }
}
