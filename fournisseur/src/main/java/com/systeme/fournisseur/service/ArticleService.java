package com.systeme.fournisseur.service;

import org.springframework.stereotype.Service;

import com.systeme.fournisseur.model.Article;
import com.systeme.fournisseur.repository.ArticleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    public Article createArticle(Article article) {
        return articleRepository.save(article);
    }

    public Article getArticleById(String id) {
        return articleRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Article non trouvé"));
    }

    public Article updateArticle(Article article) {
        if (articleRepository.existsById(article.getId())) {
            return articleRepository.save(article);
        } else {
            // Gérer le cas où l'article n'existe pas dans la base de données
            return null;
        }
    }

    public void deleteArticleById(String id) {
        articleRepository.deleteById(id);
    }

    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }
}
