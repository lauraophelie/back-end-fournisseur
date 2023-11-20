package com.systeme.fournisseur.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;

import com.systeme.fournisseur.model.Article;
import com.systeme.fournisseur.model.Demande;
import com.systeme.fournisseur.model.DetailDemande;
import com.systeme.fournisseur.model.Fournisseur;
import com.systeme.fournisseur.model.Stock;
import com.systeme.fournisseur.repository.StockRepository;

public class StockService {
    @Autowired
    private StockRepository stockRepository;

    public Stock[] getStockDemande(Demande demande) {
        List<Stock> liste = new ArrayList<>();
        for (DetailDemande detailDemande : demande.getListeDemande()) {
            Stock stock = getStockArticle(detailDemande.getArticle(), demande.getFournisseur());
            if (stock.getQuantite() >= detailDemande.getQuantite()) {
                stock.setQuantite(detailDemande.getQuantite());
            }
            liste.add(stock);
        }
        return null;
    }

    public Stock getStockArticle(Article article, Fournisseur fournisseur) {
        return stockRepository.findByArticleIdAndFournisseurId(article.getId(), fournisseur.getId());
    }

    public Stock createStock(Stock stock) {
        return stockRepository.save(stock);
    }

    public Stock getStockById(int id) {
        return stockRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Stock introuvable"));
    }

    public Stock updateStock(Stock stock) {
        // Vérifie si le stock existe dans la base de données avant la mise à jour
        if (stockRepository.existsById(stock.getId())) {
            return stockRepository.save(stock);
        } else {
            // Gérer le cas où le stock n'existe pas dans la base de données
            return null;
        }
    }

    public Stock updateStockPrice(Stock stock, double prixUnitaire) {
        stock.setPrixUnitaire(prixUnitaire);
        return updateStock(stock);
    }

    public void deleteStockById(int id) {
        stockRepository.deleteById(id);
    }

    public List<Stock> getAllStocks() {
        return stockRepository.findAll();
    }
    
}
