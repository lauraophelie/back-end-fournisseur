package com.systeme.fournisseur.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.systeme.fournisseur.model.Fournisseur;
import com.systeme.fournisseur.service.FournisseurService;

import java.util.List;
import java.util.Optional;

public class FournisseurController {
    @Autowired
    private FournisseurService uniteService;

    @GetMapping
    public List<Fournisseur> getAllFournisseurs() {
        return uniteService.getAllFournisseurs();
    }

    @GetMapping("/{id}")
    public Optional<Fournisseur> getFournisseurById(@PathVariable String id) {
        return uniteService.getFournisseurById(id);
    }

    @PostMapping
    public Fournisseur createFournisseur(@RequestBody Fournisseur unite) {
        return uniteService.createFournisseur(unite);
    }

    @PutMapping("/{id}")
    public Fournisseur updateUnite(@PathVariable String id, @RequestBody Fournisseur unite) {
        unite.setId(id);
        return uniteService.updateFournisseur(unite);
    }

    @DeleteMapping("/{id}")
    public void deleteFournisseurById(@PathVariable String id) {
        uniteService.deleteFournisseurById(id);
    }
}
