package com.systeme.fournisseur.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.systeme.fournisseur.model.Categorie;
import com.systeme.fournisseur.repository.CategorieRepository;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CategorieService{

    @Autowired
    private CategorieRepository categorieRepository; // Supposons que vous ayez une interface CategorieRepository pour interagir avec la base de données

    public Categorie getCategorieById(int id) {
        return categorieRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Kilometrage introuvable"));
    }

    public List<Categorie> getAllCategories() {
        return categorieRepository.findAll();
    }

    public void saveCategorie(Categorie categorie) {
        categorieRepository.save(categorie);
    }

    public void updateCategorie(Categorie categorie) {
        if (categorieRepository.existsById(categorie.getId())) {
            categorieRepository.save(categorie);
        }
        // Gérer le cas où la catégorie n'existe pas dans la base de données
    }

    public void deleteCategorie(int id) {
        categorieRepository.deleteById(id);
    }
}
