package com.systeme.fournisseur.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.systeme.fournisseur.model.Mail;
import com.systeme.fournisseur.repository.MailRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MailService {
    private final MailRepository mailRepository;

    @Autowired
    public MailService(MailRepository mailRepository) {
        this.mailRepository = mailRepository;
    }

    public void createMail(Mail mail) {
        mailRepository.save(mail);
    }

    public Optional<Mail> getMailById(int mailId) {
        return mailRepository.findById(mailId);
    }

    public void updateMail(Mail mail) {
        mailRepository.save(mail);
    }

    public void deleteMail(int mailId) {
        mailRepository.deleteById(mailId);
    }

    public List<Mail> getAllMails() {
        return mailRepository.findAll();
    }

}
