package com.systeme.fournisseur.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.systeme.fournisseur.api.APIResponse;
import com.systeme.fournisseur.model.Fournisseur;
import com.systeme.fournisseur.service.FournisseurService;

import java.util.List;

@RestController
@RequestMapping("/api/fournisseur/fournisseur")
public class FournisseurController {
    @Autowired
    private FournisseurService fournisseurService;

    @GetMapping
    public ResponseEntity<APIResponse> getAllFournisseurs() {
        try {
            List<Fournisseur> liste = fournisseurService.getAllFournisseurs();
            return new ResponseEntity<APIResponse>(new APIResponse("", liste), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<APIResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<APIResponse> getFournisseurById(@PathVariable String id) {
        try {
            Fournisseur liste = fournisseurService.getFournisseurById(id);
            return new ResponseEntity<APIResponse>(new APIResponse("", liste), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<APIResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public Fournisseur createFournisseur(@RequestBody Fournisseur unite) {
        return fournisseurService.createFournisseur(unite);
    }

    @PutMapping("/{id}")
    public ResponseEntity<APIResponse> updateUnite(@PathVariable String id, @RequestBody Fournisseur unite) {
        unite.setId(id);
        try {
            Fournisseur liste = fournisseurService.updateFournisseur(unite);
            return new ResponseEntity<APIResponse>(new APIResponse("", liste), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<APIResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public void deleteFournisseurById(@PathVariable String id) {
        fournisseurService.deleteFournisseurById(id);
    }
}
