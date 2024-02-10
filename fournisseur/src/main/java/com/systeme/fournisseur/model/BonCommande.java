package com.systeme.fournisseur.model;

import java.sql.Date;

public class BonCommande {
    int id;
    Date dateTirage;
    String numero;
    Date delaiLivraison;
    boolean partiel;
    String paiement;
    int id_proforma;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateTirage() {
        return dateTirage;
    }

    public void setDateTirage(Date dateTirage) {
        this.dateTirage = dateTirage;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Date getDelaiLivraison() {
        return delaiLivraison;
    }

    public void setDelaiLivraison(Date delaiLivraison) {
        this.delaiLivraison = delaiLivraison;
    }

    public boolean isPartiel() {
        return partiel;
    }

    public void setPartiel(boolean partiel) {
        this.partiel = partiel;
    }

    public String getPaiement() {
        return paiement;
    }

    public void setPaiement(String paiement) {
        this.paiement = paiement;
    }

    public int getId_proforma() {
        return id_proforma;
    }

    public void setId_proforma(int id_proforma) {
        this.id_proforma = id_proforma;
    }
}
