package com.fpl.fplmaster.controller.rest;

import com.fpl.fplmaster.email.EmailHandler;
import com.fpl.fplmaster.model.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/email")
public class EmailController {
    EmailHandler emailHandler;

    @Autowired
    public EmailController(EmailHandler emailHandler) {
        this.emailHandler = emailHandler;
    }

    @GetMapping
    public void emailSubmit(@ModelAttribute Email email) {
        System.out.println(email.getEmail());
        emailHandler.sendMessage(email);
    }

}
