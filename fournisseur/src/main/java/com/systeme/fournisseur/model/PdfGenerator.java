package com.systeme.fournisseur.model;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;

import java.io.FileOutputStream;
import java.io.IOException;

public class PdfGenerator {

    public static void generateInvoice() throws DocumentException, IOException {
        Document document = new Document(PageSize.A4, 25, 25, 25, 25);
        try {
            PdfWriter.getInstance(document, new FileOutputStream("Facture.pdf"));
            document.open();

            // Titre de la facture
            Paragraph title = new Paragraph("Facture", new Font(Font.FontFamily.HELVETICA, 30, Font.BOLD));
            title.setAlignment(Paragraph.ALIGN_CENTER);
            title.setSpacingBefore(20);
            title.setSpacingAfter(20);

            document.add(title);

            PdfPTable table = new PdfPTable(2);
            table.setWidthPercentage(100);

            PdfPCell cell;

            // Détails du fournisseur dans la première colonne
            // Détails du fournisseur dans la première colonne
            Font cellFont = new Font(Font.FontFamily.HELVETICA, 12);
            Paragraph p = new Paragraph(
                    "Détails du fournisseur :\nNom: XYZ Company\nAdresse: Rue ABC, Ville\nContact: contact@xyz.com",
                    cellFont);
            p.setAlignment(20);
            
            cell = new PdfPCell(p);
            cell.setBorder(0); // Supprime les bordures
            table.addCell(cell);

            // Détails du client dans la deuxième colonne
            p = new Paragraph(
                    "Détails du client :\nNom: Client Name\nAdresse: Rue Client, Ville\nContact: client@email.com",
                    cellFont);
            p.setLeading(20f);
            cell = new PdfPCell(p);
            cell.setBorder(0); // Supprime les bordures
            table.addCell(cell);

            document.add(table);

            // Tableau pour les produits livrés
            table = new PdfPTable(6); // Nombre de colonnes
            table.setWidthPercentage(100);

            // Entêtes du tableau
            table.addCell("ID");
            table.addCell("Désignation");
            table.addCell("Quantité");
            table.addCell("Unité");
            table.addCell("Prix unitaire");
            table.addCell("Montant");

            // Exemple de données dans le tableau (à remplacer par tes données réelles)
            table.addCell("1");
            table.addCell("Produit A");
            table.addCell("5");
            table.addCell("Pièce");
            table.addCell("10.00");
            table.addCell("50.00");

            // Ajoute d'autres lignes de produits ici...

            document.add(table);
            document.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}