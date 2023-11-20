package com.systeme.fournisseur.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.systeme.fournisseur.model.Stock;

public interface StockRepository extends JpaRepository<Stock, Integer> {
    Stock findByArticleIdAndFournisseurId(String idArticle, String idFournisseur);
}
