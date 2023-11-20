package com.systeme.fournisseur.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.systeme.fournisseur.model.Categorie;

public interface CategorieRepository extends JpaRepository<Categorie, Integer> {

}
