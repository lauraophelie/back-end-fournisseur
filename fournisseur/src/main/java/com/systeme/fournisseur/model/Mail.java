package com.systeme.fournisseur.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "mail")
public class Mail {

    @Id
    @Column(name = "id_mail", columnDefinition = "int default nextval(mail_demande_id_mail_seq) not null")
    int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "id_fournisseur")
    Fournisseur fournisseur;

    public Fournisseur getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(Fournisseur fournisseur) {
        this.fournisseur = fournisseur;
    }

    @Column(name = "objet")
    String objet;

    public String getObjet() {
        return objet;
    }

    public void setObjet(String objet) {
        this.objet = objet;
    }

    @OneToMany(mappedBy = "mail", cascade = CascadeType.ALL)
    List<FicheArticle> listeArticles;

    public List<FicheArticle> getListeArticles() {
        return listeArticles;
    }

    public void setListeArticles(List<FicheArticle> listeArticles) {
        this.listeArticles = listeArticles;
    }

    @OneToMany(mappedBy = "mail", cascade = CascadeType.ALL)
    List<Proforma> listeFicheProformat;

    public List<Proforma> getListeFicheProformat() {
        return listeFicheProformat;
    }

    public void setListeFicheProformat(List<Proforma> listeProFicheProformat) {
        this.listeFicheProformat = listeProFicheProformat;
    }

    @ManyToOne
    @JoinColumn(name = "id_entreprise")
    Entreprise entreprise;

    public Entreprise getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(Entreprise entreprise) {
        this.entreprise = entreprise;
    }
}
