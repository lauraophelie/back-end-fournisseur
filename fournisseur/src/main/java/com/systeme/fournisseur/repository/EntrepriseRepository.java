package com.systeme.fournisseur.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.systeme.fournisseur.model.Entreprise;

public interface EntrepriseRepository extends JpaRepository<Entreprise, String> {

}
