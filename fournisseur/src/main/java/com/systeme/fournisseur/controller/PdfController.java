package com.systeme.fournisseur.controller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.systeme.fournisseur.api.APIResponse;
import com.systeme.fournisseur.model.PdfGenerator;
import com.systeme.fournisseur.pdf.TemplatePDF;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api/fournisseur/pdf")
public class PdfController {

    @GetMapping("/facture")
    public ResponseEntity<?> getFacture() {
        try{
            new TemplatePDF().generatePDF();
            return ResponseEntity.ok(new APIResponse("", true));
        } catch(Exception e){
            APIResponse response = new APIResponse(e.toString(), false);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
        /*byte[] bytes = null;
        try {
            bytes = PdfGenerator.generateInvoice();
        } catch (DocumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_PDF)
                .body(bytes);*/
    }
    @GetMapping("/test")
    public ResponseEntity<?> getLoadTest() {
        Document document = new Document(PageSize.A4, 50, 50, 50, 50);
        try {
        // creation of the different writers
        //HtmlWriter.getInstance(document , System.out);
        try {
            PdfWriter.getInstance(document , new FileOutputStream("text.pdf"));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // we add some meta information to the document
        document.addAuthor("Bruno Lowagie"); 
        document.addSubject("This is the result of a Test."); 
        // we open the document for writing
        document.open(); 
        document.add(new Paragraph("Hello world"));
        } catch(DocumentException de) {
        System.err.println(de.getMessage());
        }
        document.close();
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
