package com.systeme.fournisseur.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.systeme.fournisseur.model.Article;
import com.systeme.fournisseur.service.ArticleService;

@RestController
@RequestMapping("/api/fournisseur/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @GetMapping
    public List<Article> getAllArticles() {
        return articleService.getAllArticles();
    }

    @GetMapping("/{id}")
    public Article getArticleById(@PathVariable String id) {
        return articleService.getArticleById(id);
    }

    @PostMapping
    public Article createarticle(@RequestBody Article article) {
        return articleService.createArticle(article);
    }

    @PutMapping("/{id}")
    public Article updatearticle(@PathVariable String id, @RequestBody Article article) {
        article.setId(id);
        return articleService.updateArticle(article);
    }

    @DeleteMapping("/{id}")
    public void deleteArticleById(@PathVariable String id) {
        articleService.deleteArticleById(id);
    }
}
