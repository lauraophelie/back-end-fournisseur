package com.systeme.fournisseur.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.systeme.fournisseur.model.Mail;

public interface MailRepository extends JpaRepository<Mail,Integer>{
    
}
