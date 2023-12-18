package com.systeme.fournisseur.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.systeme.fournisseur.model.Facture;

@Repository
public interface FactureRepository extends JpaRepository<Facture, Integer> {

}
