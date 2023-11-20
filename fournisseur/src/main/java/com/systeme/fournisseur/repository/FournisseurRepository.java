package com.systeme.fournisseur.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.systeme.fournisseur.model.Fournisseur;

public interface FournisseurRepository extends JpaRepository<Fournisseur, String> {

}
