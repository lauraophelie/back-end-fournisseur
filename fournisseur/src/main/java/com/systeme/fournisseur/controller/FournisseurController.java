package com.systeme.fournisseur.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.systeme.fournisseur.model.Fournisseur;
import com.systeme.fournisseur.service.FournisseurService;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api/fournisseur/fournisseur")
public class FournisseurController {
    @Autowired
    private FournisseurService fournisseurService;

    @GetMapping
    public List<Fournisseur> getAllFournisseurs() {
        return fournisseurService.getAllFournisseurs();
    }

    @GetMapping("/{id}")
    public Fournisseur getFournisseurById(@PathVariable String id) {
        return fournisseurService.getFournisseurById(id);
    }

    @PostMapping
    public Fournisseur createFournisseur(@RequestBody Fournisseur unite) {
        return fournisseurService.createFournisseur(unite);
    }

    @PutMapping("/{id}")
    public Fournisseur updateUnite(@PathVariable String id, @RequestBody Fournisseur unite) {
        unite.setId(id);
        return fournisseurService.updateFournisseur(unite);
    }

    @DeleteMapping("/{id}")
    public void deleteFournisseurById(@PathVariable String id) {
        fournisseurService.deleteFournisseurById(id);
    }
}
