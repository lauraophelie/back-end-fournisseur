package com.systeme.fournisseur.controller;

import org.springframework.web.bind.annotation.RestController;

import com.systeme.fournisseur.model.Facture;
import com.systeme.fournisseur.service.FactureService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/factures")
public class FactureController {

    private final FactureService factureService;

    public FactureController(FactureService factureService) {
        this.factureService = factureService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Facture> getFactureById(@PathVariable Integer id) {
        Facture facture = factureService.findById(id);
        if (facture != null) {
            return ResponseEntity.ok(facture);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Facture>> getAllFactures() {
        List<Facture> factures = factureService.findAll();
        return ResponseEntity.ok(factures);
    }

    @PostMapping
    public ResponseEntity<Facture> createFacture(@RequestBody Facture facture) {
        Facture createdFacture = factureService.saveFacture(facture);
        return new ResponseEntity<>(createdFacture, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFacture(@PathVariable Integer id) {
        factureService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
