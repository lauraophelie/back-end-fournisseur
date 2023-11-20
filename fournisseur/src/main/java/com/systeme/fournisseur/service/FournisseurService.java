package com.systeme.fournisseur.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.systeme.fournisseur.model.Fournisseur;
import com.systeme.fournisseur.repository.FournisseurRepository;

import java.util.List;
import java.util.Optional;

@Service
public class FournisseurService {

    @Autowired
    private FournisseurRepository fournisseurRepository;

    public Fournisseur createFournisseur(Fournisseur fournisseur) {
        return fournisseurRepository.save(fournisseur);
    }

    public Optional<Fournisseur> getFournisseurById(String id) {
        return fournisseurRepository.findById(id);
    }

    public Fournisseur updateFournisseur(Fournisseur fournisseur) {
        if (fournisseurRepository.existsById(fournisseur.getId())) {
            return fournisseurRepository.save(fournisseur);
        } else {
            // Gérer le cas où le fournisseur n'existe pas dans la base de données
            return null;
        }
    }

    public void deleteFournisseurById(String id) {
        fournisseurRepository.deleteById(id);
    }

    public List<Fournisseur> getAllFournisseurs() {
        return fournisseurRepository.findAll();
    }
}
