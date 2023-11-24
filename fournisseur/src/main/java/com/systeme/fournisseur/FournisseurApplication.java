package com.systeme.fournisseur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.systeme.fournisseur.service.EmailService;

@SpringBootApplication
public class FournisseurApplication implements CommandLineRunner {

	@Autowired
	private EmailService emailService;
	public static void main(String[] args) {
		SpringApplication.run(FournisseurApplication.class, args);
	}

	@Override
    public void run(String... args) {
        // Exemple d'envoi d'e-mail
        String destinataire = "destinataire@example.com";
        String sujet = "Test d'envoi d'e-mail";
        String contenu = "Ceci est un e-mail de test envoyé depuis Spring Boot.";

        emailService.sendEmail(destinataire, sujet, contenu);
    }
}
