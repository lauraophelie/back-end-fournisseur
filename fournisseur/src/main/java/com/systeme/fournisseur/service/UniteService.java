package com.systeme.fournisseur.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.systeme.fournisseur.model.Unite;
import com.systeme.fournisseur.repository.UniteRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UniteService {

    @Autowired
    private UniteRepository uniteRepository;

    public Unite createUnite(Unite unite) {
        return uniteRepository.save(unite);
    }

    public Optional<Unite> getUniteById(int id) {
        return uniteRepository.findById(id);
    }

    public Unite updateUnite(Unite unite) {
        if (uniteRepository.existsById(unite.getId())) {
            return uniteRepository.save(unite);
        } else {
            // Gérer le cas où l'unité n'existe pas dans la base de données
            return null;
        }
    }

    public void deleteUniteById(String id) {
        int newId = Integer.parseInt(id);
        uniteRepository.deleteById(newId);
    }

    public List<Unite> getAllUnites() {
        return uniteRepository.findAll();
    }
}
