package com.systeme.fournisseur.model;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "bon_livraison")
public class BonLivraison {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_b_livraison")
    private int idFacture;

    public int getIdFacture() {
        return idFacture;
    }

    public void setIdFacture(int idFacture) {
        this.idFacture = idFacture;
    }

    @Column(name = "id_bc", nullable = false)
    private int idBc;

    public int getIdBc() {
        return idBc;
    }

    public void setIdBc(int idBc) {
        this.idBc = idBc;
    }

    @Column(name = "date_emis", nullable = false)
    private Date dateEmis;

    public Date getDateEmis() {
        return dateEmis;
    }

    public void setDateEmis(Date dateEmis) {
        this.dateEmis = dateEmis;
    }

    @Column(name = "id_fournisseur", nullable = false)
    private String idFournisseur;

    public String getIdFournisseur() {
        return idFournisseur;
    }

    public void setIdFournisseur(String idFournisseur) {
        this.idFournisseur = idFournisseur;
    }

    @Column(name = "id_entreprise", nullable = false)
    private String idEntreprise;

    public String getIdEntreprise() {
        return idEntreprise;
    }

    public void setIdEntreprise(String idEntreprise) {
        this.idEntreprise = idEntreprise;
    }

    @OneToMany(mappedBy = "bonLivraison", cascade = CascadeType.ALL)
    private List<DetailsBonLivraison> details;

    public List<DetailsBonLivraison> getDetails() {
        return details;
    }

    public void setDetails(List<DetailsBonLivraison> details) {
        this.details = details;
    }
}