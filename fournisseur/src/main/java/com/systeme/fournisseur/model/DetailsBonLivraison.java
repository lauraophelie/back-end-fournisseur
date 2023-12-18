package com.systeme.fournisseur.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "details_b_livraison")
public class DetailsBonLivraison {
    @Id
    @Column(name = "id_d_bl")
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "id_article")
    private Article article;

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    @Column(name = "quantite")
    double quantite;

    public double getQuantite() {
        return quantite;
    }

    public void setQuantite(double quantite) {
        this.quantite = quantite;
    }

    @ManyToOne
    @JoinColumn(name = "id_b_livraison")
    private BonLivraison bonLivraison;

    public BonLivraison getBonLivraison() {
        return bonLivraison;
    }

    public void setBonLivraison(BonLivraison bonLivraison) {
        this.bonLivraison = bonLivraison;
    }

    @Column(name = "remarque")
    private String remarque;

    public String getRemarque() {
        return remarque;
    }

    public void setRemarque(String remarque) {
        this.remarque = remarque;
    }
}
