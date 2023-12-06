package com.systeme.fournisseur.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.systeme.fournisseur.api.EmailRequest;
import com.systeme.fournisseur.service.EmailService;

@RestController
public class EmailController {

    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping("/send-email")
    public String sendEmail(@RequestBody EmailRequest emailRequest) {
        // Récupérer les détails de l'e-mail depuis la requête ou toute autre source
        String to = emailRequest.getTo();
        String subject = emailRequest.getSubject();
        String text = emailRequest.getText();

        // Envoyer l'e-mail
        emailService.sendEmail(to, subject, text);

        return "Email sent successfully!";
    }
}