package com.systeme.fournisseur.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.systeme.fournisseur.model.Article;

public interface ArticleRepository extends JpaRepository<Article, String> {

}
