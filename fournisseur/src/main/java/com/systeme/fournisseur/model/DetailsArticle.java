package com.systeme.fournisseur.model;

public class DetailsArticle {
    private Article article;

    public DetailsArticle(Article article2) {
        setArticle(article2);
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    private double quantite;

    public double getQuantite() {
        return quantite;
    }

    public void setQuantite(double quantite) {
        this.quantite = quantite;
    }

    private double prixUnitaire;

    public double getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(double prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }

    private double montant;

    public double getMontant() {
        return montant;
    }

    public void setMontant() {
        this.montant = this.quantite * this.prixUnitaire;
    }
}
