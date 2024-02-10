package com.systeme.fournisseur.api;

public class EmailRequest {

    private String to;
    private String subject;
    private String text;

    // Constructeur par défaut (ou définissez un constructeur avec les champs
    // requis)

    // Getters et Setters pour les champs

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
