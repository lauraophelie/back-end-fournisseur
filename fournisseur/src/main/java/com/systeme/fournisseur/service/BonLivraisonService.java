package com.systeme.fournisseur.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.systeme.fournisseur.model.BonLivraison;
import com.systeme.fournisseur.repository.BonLivraisonRepository;

@Service
public class BonLivraisonService {
    private final BonLivraisonRepository bonLivraisonRepository;

    public BonLivraisonService(BonLivraisonRepository bonLivraisonRepository) {
        this.bonLivraisonRepository = bonLivraisonRepository;
    }

    public BonLivraison findById(Integer id) {
        return bonLivraisonRepository.findById(id).orElse(null);
    }

    public List<BonLivraison> findAll() {
        return bonLivraisonRepository.findAll();
    }

    public BonLivraison saveBonLivraison(BonLivraison BonLivraison) {
        return bonLivraisonRepository.save(BonLivraison);
    }

    public void deleteById(Integer id) {
        bonLivraisonRepository.deleteById(id);
    }
}
