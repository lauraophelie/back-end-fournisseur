package com.systeme.fournisseur.model;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;
import com.itextpdf.text.pdf.PdfPTable;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class PdfGenerator {

    public static byte[] generateInvoice() throws DocumentException, IOException {
        Document document = new Document(PageSize.A4, 25, 25, 25, 25);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PdfWriter.getInstance(document, out);
        document.open();

        // Add invoice details
        document.add(new Paragraph("Invoice Number: 12345"));
        document.add(new Paragraph("Invoice Date: 12/06/2023"));

        // Add table for items
        PdfPTable table = new PdfPTable(3); // 3 columns.
        table.addCell("Item");
        table.addCell("Quantity");
        table.addCell("Price");

        // Add items
        table.addCell("Item 1");
        table.addCell("1");
        table.addCell("100");

        // Add table to document
        document.add(table);

        document.close();
        return out.toByteArray();
    }
}