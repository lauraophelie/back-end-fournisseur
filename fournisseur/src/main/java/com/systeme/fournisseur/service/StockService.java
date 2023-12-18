package com.systeme.fournisseur.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.systeme.fournisseur.model.Article;
import com.systeme.fournisseur.model.Mail;
import com.systeme.fournisseur.model.FicheArticle;
import com.systeme.fournisseur.model.Proforma;
import com.systeme.fournisseur.model.Fournisseur;
import com.systeme.fournisseur.model.Stock;
import com.systeme.fournisseur.repository.StockRepository;

@Service
public class StockService {

    @Autowired
    private StockRepository stockRepository;

    public Mail getStockDemande(Mail demande) {
        List<Proforma> liste = new ArrayList<>();
        for (FicheArticle detailDemande : demande.getListeArticles()) {
            Proforma fiche = new Proforma(detailDemande);
            Stock stock = getStockArticle(detailDemande.getArticle(), demande.getFournisseur());
            if (stock.getQuantite() < detailDemande.getQuantite()) {
                fiche.setQuantite(stock.getQuantite());
            }
            fiche.setPrixUnitaire(stock.getPrixUnitaire());
            liste.add(fiche);
        }
        Mail mail = new Mail();
        mail.setEntreprise(demande.getEntreprise());
        mail.setFournisseur(demande.getFournisseur());
        mail.setListeFicheProformat(liste);
        return mail;
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
