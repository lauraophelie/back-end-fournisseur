package com.systeme.fournisseur.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.systeme.fournisseur.api.APIResponse;
import com.systeme.fournisseur.model.Article;
import com.systeme.fournisseur.service.ArticleService;

@RestController
@RequestMapping("/api/fournisseur/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @GetMapping
    public ResponseEntity<APIResponse> getAllArticles() {
        try {
            List<Article> liste = articleService.getAllArticles();
            return new ResponseEntity<>(new APIResponse("", liste), HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(new APIResponse(exception.getMessage(), ""), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public Article getArticleById(@PathVariable String id) {
        return articleService.getArticleById(id);
    }

    @PostMapping
    public ResponseEntity<APIResponse> createarticle(@RequestBody Article article) {
        try {
            Article liste = articleService.createArticle(article);
            return new ResponseEntity<>(new APIResponse("", liste), HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(new APIResponse(exception.getMessage(), ""), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<APIResponse> updatearticle(@PathVariable String id, @RequestBody Article article) {
        article.setId(id);
        try {
            Article liste = articleService.updateArticle(article);
            return new ResponseEntity<>(new APIResponse("", liste), HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(new APIResponse(exception.getMessage(), ""), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public void deleteArticleById(@PathVariable String id) {
        articleService.deleteArticleById(id);
    }
}
