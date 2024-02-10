package com.systeme.fournisseur.pdf;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfWriter;
import com.systeme.fournisseur.model.Article;
import com.systeme.fournisseur.model.DetailsArticle;
import com.systeme.fournisseur.model.Unite;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.Font.FontFamily;

import java.io.FileOutputStream;
import java.io.IOException;

public class TemplatePDF {
    private String objet;
    private Date dateEmission;
    private List<String> reference;
    private List<DetailsArticle> articles;
    private Document document;

    private static FontFamily base = FontFamily.HELVETICA;
    private static Font normal = new Font(base, 10);
    private static Font titre = new Font(base, 16, Font.BOLD);
    private static Font numeroObjet = new Font(base, 11, Font.BOLD);
    private static Font soustitre = new Font(base, 10, Font.BOLD);
    private static Font nb = new Font(base, 8);

    public String getObjet() {
        return objet;
    }

    public void setObjet(String objet) {
        this.objet = objet;
    }

    public Date getDateEmission() {
        return dateEmission;
    }

    public void setDateEmission(Date dateEmission) {
        this.dateEmission = dateEmission;
    }

    public List<String> getReference() {
        return reference;
    }

    public void setReference(List<String> reference) {
        this.reference = reference;
    }

    public List<DetailsArticle> getArticles() {
        return articles;
    }

    public void setArticles(List<DetailsArticle> articles) {
        this.articles = articles;
    }

    public TemplatePDF() {
    }

    public TemplatePDF(String object, Date dateEmission, List<String> reference, List<DetailsArticle> articles)
            throws DocumentException, IOException {
        setObjet(object);
        setDateEmission(dateEmission);
        setReference(reference);
        setArticles(articles);
        generatePDF();
    }

    public void generatePDF() throws DocumentException, IOException {
        document = new Document(PageSize.A4, 30, 30, 40, 20);
        try {

            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("pdf/Facture.pdf"));

            document.open();

            Image background = Image.getInstance("img/background.png");
            background.setAbsolutePosition(0, 0); // Position de l'image dans le coin supérieur gauche
            background.scaleAbsolute(document.getPageSize()); // Redimensionne l'image pour couvrir toute la page

            // Ajout de l'arrière-plan sur chaque page
            writer.getDirectContentUnder().addImage(background);

            setTitle("Facture");
            setHead();
            addEntities();
            List<String> references = new ArrayList<>();
            references.add("BC0001");
            references.add("BL0001");
            addReferences(references);

            Article article = new Article();
            article.setId("ART1");
            article.setDesignation("Stylo");
            Unite unite = new Unite();
            unite.setId(3);
            unite.setNom("paquet");
            article.setUnite(unite);
            List<DetailsArticle> liste = new ArrayList<>();
            for (int i = 0; i < 4; i++) {
                DetailsArticle detailsArticle = new DetailsArticle(article);
                detailsArticle.setPrixUnitaire(4000);
                detailsArticle.setQuantite(14);
                detailsArticle.setMontant();
                liste.add(detailsArticle);
            }

            // Tableau pour les produits livrés
            addTableDetails(document, liste);
            addTableSum();
            addModePaiement();
            addTotalEnLettre();

            document.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setHead() throws DocumentException {
        PdfPTable table = new PdfPTable(3);
        table.setWidthPercentage(100);
        float[] columnWidths = { 45f, 10f, 45f };
        table.setWidths(columnWidths);

        Paragraph p1 = new Paragraph("Date: ", normal);
        Paragraph p2 = new Paragraph("Numero", numeroObjet);
        PdfPCell cell = new PdfPCell();
        cell.setBorder(0);
        table.addCell(cell);
        table.addCell(cell);
        cell.addElement(p1);
        cell.addElement(p2);
        table.addCell(cell);
        table.setSpacingAfter(10);
        document.add(table);
    }

    public void setTitle(String string) throws DocumentException {
        // Titre de la facture
        Paragraph title = new Paragraph(string, titre);
        title.setAlignment(Paragraph.ALIGN_CENTER);
        title.setSpacingAfter(20);
        document.add(title);
    }

    public Paragraph normalParagraph(String text) {
        Paragraph p = new Paragraph(text, normal);
        p.setSpacingAfter(1);
        return p;
    }

    public Paragraph soustitreParagraph(String text) {
        Paragraph p = new Paragraph(text, soustitre);
        p.setSpacingAfter(1);
        return p;
    }

    public PdfPCell addFournisseur() {
        PdfPCell cell = new PdfPCell();
        cell.setBorder(0);
        cell.addElement(soustitreParagraph("Nom de l'entreprise"));
        cell.addElement(normalParagraph("Adresse"));
        cell.addElement(normalParagraph("Code postale, Ville"));
        cell.addElement(normalParagraph("Numero téléphone"));
        cell.addElement(normalParagraph("Email"));
        return cell;
    }

    public PdfPCell addClient() {
        PdfPCell cell = new PdfPCell();
        cell.setBorder(0);
        cell.addElement(soustitreParagraph("Nom du client"));
        cell.addElement(normalParagraph("Adresse"));
        cell.addElement(normalParagraph("Code postale, Ville"));
        cell.addElement(normalParagraph("Numero téléphone"));
        cell.addElement(normalParagraph("Email"));
        return cell;
    }

    public void addEntities() throws DocumentException {
        // table client et fournisseur
        PdfPTable table = new PdfPTable(3);
        table.setWidthPercentage(100);
        float[] columnWidths = { 45f, 10f, 45f };
        table.setWidths(columnWidths);

        PdfPCell cell = new PdfPCell();
        cell.setBorder(0);
        table.addCell(addFournisseur());
        table.addCell(cell);
        table.addCell(addClient());

        // ajout table
        table.setSpacingAfter(20);
        document.add(table);
    }

    public void addReferences(List<String> reference) throws DocumentException {
        Paragraph paragraph = new Paragraph();
        paragraph.add(new Phrase("References : ", soustitre));
        for (int index = 0; index < reference.size(); index++) {
            if (index != 0)
                paragraph.add(new Phrase(", ", normal));
            paragraph.add(new Phrase(reference.get(index), normal));
        }
        paragraph.setSpacingAfter(20);
        document.add(paragraph);
    }

    public PdfPCell newCell(Object content) throws Exception {
        if (content == null) {
            throw new Exception("Erreur: content null: newCell(Object content): ligne 223");
        }
        PdfPCell cell = new PdfPCell();
        Paragraph paragraph = normalParagraph(content.toString());
        cell.addElement(paragraph);
        cell.setPaddingLeft(10);
        cell.setPaddingBottom(5);
        cell.setPaddingTop(5);
        cell.setPaddingRight(10);
        return cell;
    }

    private PdfPCell newCell(String content, Font styleSpec) throws Exception {
        if (content == null) {
            throw new Exception("Erreur: content null: newCell(Object content): ligne 223");
        }
        PdfPCell cell = new PdfPCell();
        Paragraph paragraph = new Paragraph(content.toString(), styleSpec);
        cell.addElement(paragraph);
        cell.setPaddingLeft(10);
        cell.setPaddingBottom(10);
        cell.setPaddingTop(10);
        cell.setPaddingRight(10);
        return cell;
    }

    public void addTableDetails(Document document, List<DetailsArticle> listeArticles)
            throws DocumentException, Exception {
        PdfPTable table = new PdfPTable(6); // Nombre de colonnes
        table.setWidthPercentage(100);
        float[] columnWidths = { 15f, 25f, 15f, 15f, 15f, 15f };
        table.setWidths(columnWidths);

        // Entêtes du tableau
        table.addCell(newCell("Reference article"));
        table.addCell(newCell("Désignation"));
        table.addCell(newCell("Quantité"));
        table.addCell(newCell("Unité"));
        table.addCell(newCell("Prix unitaire"));
        table.addCell(newCell("Montant"));

        // Exemple de données dans le tableau (à remplacer par tes données réelles)

        for (DetailsArticle details : listeArticles) {
            table.addCell(newCell(details.getArticle().getId()));
            table.addCell(newCell(details.getArticle().getDesignation()));
            table.addCell(newCell(details.getQuantite()));
            table.addCell(newCell(details.getArticle().getUnite().getNom()));
            table.addCell(newCell(details.getPrixUnitaire()));
            table.addCell(newCell(details.getMontant() + " Ar"));
        }

        table.setSpacingAfter(20);
        document.add(table);
    }

    /**
     * @param document
     * @throws Exception
     */
    public void addTableSum() throws Exception {
        PdfPTable table = new PdfPTable(3); // Nombre de colonnes
        table.setWidthPercentage(100);
        float[] columnWidths = { 45f, 30f, 25f };
        table.setWidths(columnWidths);
        PdfPCell cell = new PdfPCell();
        cell.setBorder(0);

        // montant total HT
        table.addCell(cell);
        table.addCell(newCell("Total HT"));
        table.addCell(new PdfPCell());

        // remise HT
        table.addCell(cell);
        table.addCell(newCell("Remise HT"));
        table.addCell(new PdfPCell());

        // total TVA
        table.addCell(cell);
        table.addCell(newCell("Total Net HT"));
        table.addCell(new PdfPCell());

        // Montant Total TTC
        table.addCell(cell);
        table.addCell(newCell("Total TVA"));
        table.addCell(new PdfPCell());
        // Montant déjà versé
        table.addCell(cell);
        table.addCell(newCell("Montant Total HT", numeroObjet));
        table.addCell(new PdfPCell());

        // Reste à payer
        table.addCell(cell);
        table.addCell(newCell("Montant Total HT"));
        table.addCell(new PdfPCell());

        table.setSpacingAfter(20);
        document.add(table);
    }

    public void addModePaiement() throws Exception {
        Paragraph p1 = new Paragraph("Mode de règlement: ", nb);
        document.add(p1);
        p1 = new Paragraph("Condition de règlement: ", nb);
        document.add(p1);
        p1 = new Paragraph("Date limite de règlement: ", nb);
        p1.setSpacingAfter(20);
        document.add(p1);
    }

    public void addTotalEnLettre() throws Exception {
        PdfPTable table = new PdfPTable(1);
        table.setWidthPercentage(100);
        PdfPCell cell = new PdfPCell(new Phrase("La présente facture est arrêté à la somme de ... ariary"));
        cell.setPadding(10);
        table.addCell(cell);
        document.add(table);
    }
}
