package com.systeme.fournisseur.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.systeme.fournisseur.model.Unite;
import com.systeme.fournisseur.service.UniteService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/fournisseur/unite")
public class UniteController {

    @Autowired
    private UniteService uniteService;

    @GetMapping
    public List<Unite> getAllUnites() {
        return uniteService.getAllUnites();
    }

    @GetMapping("/{id}")
    public Optional<Unite> getUniteById(@PathVariable String id) {
        return uniteService.getUniteById(id);
    }

    @PostMapping
    public Unite createUnite(@RequestBody Unite unite) {
        return uniteService.createUnite(unite);
    }

    @PutMapping("/{id}")
    public Unite updateUnite(@PathVariable String id, @RequestBody Unite unite) {
        unite.setId(id);
        return uniteService.updateUnite(unite);
    }

    @DeleteMapping("/{id}")
    public void deleteUniteById(@PathVariable String id) {
        uniteService.deleteUniteById(id);
    }
}
