package com.systeme.fournisseur.model;

public class FicheProformat extends FicheArticle {
    private double prixUnitaire;

    public double getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(double prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }

    public FicheProformat() {
    }

    public FicheProformat(FicheArticle ficheArticle) {
        this.setArticle(ficheArticle.getArticle());
        this.setQuantite(ficheArticle.getQuantite());
    }
}
