package com.systeme.fournisseur.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.systeme.fournisseur.model.BonLivraison;
import com.systeme.fournisseur.service.BonLivraisonService;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("api/bonlivraison")
public class BonLivraisonController {
    private final BonLivraisonService bonLivraisonService;

    public BonLivraisonController(BonLivraisonService bonLivraisonService) {
        this.bonLivraisonService = bonLivraisonService;
    }

    @GetMapping()
    public ResponseEntity<BonLivraison> getFactureById(@PathVariable Integer id) {
        BonLivraison bl = bonLivraisonService.findById(id);
        if (bl != null) {
            return ResponseEntity.ok(bl);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
