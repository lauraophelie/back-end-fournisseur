package com.systeme.fournisseur.service;

import org.springframework.stereotype.Service;

import com.systeme.fournisseur.model.Facture;
import com.systeme.fournisseur.repository.FactureRepository;

import java.util.List;

@Service
public class FactureService {

    private final FactureRepository factureRepository;

    public FactureService(FactureRepository factureRepository) {
        this.factureRepository = factureRepository;
    }

    public Facture findById(Integer id) {
        return factureRepository.findById(id).orElse(null);
    }

    public List<Facture> findAll() {
        return factureRepository.findAll();
    }

    public Facture saveFacture(Facture facture) {
        return factureRepository.save(facture);
    }

    public void deleteById(Integer id) {
        factureRepository.deleteById(id);
    }

}
