package com.systeme.fournisseur.model;

import java.util.List;

public class Mail {
    String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    Fournisseur fournisseur;

    public Fournisseur getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(Fournisseur fournisseur) {
        this.fournisseur = fournisseur;
    }

    String objet;

    public String getObjet() {
        return objet;
    }

    public void setObjet(String objet) {
        this.objet = objet;
    }

    List<FicheArticle> listeArticles;

    public List<FicheArticle> getListeArticles() {
        return listeArticles;
    }

    public void setListeArticles(List<FicheArticle> listeArticles) {
        this.listeArticles = listeArticles;
    }

    List<FicheProformat> listeFicheProformat;

    public List<FicheProformat> getListeFicheProformat() {
        return listeFicheProformat;
    }

    public void setListeFicheProformat(List<FicheProformat> listeProFicheProformat) {
        this.listeFicheProformat = listeProFicheProformat;
    }

    Entreprise entreprise;

    public Entreprise getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(Entreprise entreprise) {
        this.entreprise = entreprise;
    }
}
