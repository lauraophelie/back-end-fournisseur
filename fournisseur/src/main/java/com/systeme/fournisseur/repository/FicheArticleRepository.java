package com.systeme.fournisseur.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.systeme.fournisseur.model.FicheArticle;

public interface FicheArticleRepository extends JpaRepository<FicheArticle, Integer> {
}
