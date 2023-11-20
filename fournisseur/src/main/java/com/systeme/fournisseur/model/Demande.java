package com.systeme.fournisseur.model;

import java.sql.Date;

public class Demande {
    private DetailDemande[] listeDemande;

    public DetailDemande[] getListeDemande() {
        return listeDemande;
    }

    public void setListeDemande(DetailDemande[] listeDemande) {
        this.listeDemande = listeDemande;
    }

    private Fournisseur fournisseur;

    public Fournisseur getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(Fournisseur fournisseur) {
        this.fournisseur = fournisseur;
    }

    private Entreprise entreprise;

    public Entreprise getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(Entreprise entreprise) {
        this.entreprise = entreprise;
    }

    private Date dateDemande;

    public Date getDateDemande() {
        return dateDemande;
    }

    public void setDateDemande(Date dateDemande) {
        this.dateDemande = dateDemande;
    }
}
