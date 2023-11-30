package com.systeme.fournisseur.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.systeme.fournisseur.api.APIResponse;
import com.systeme.fournisseur.model.Mail;
import com.systeme.fournisseur.service.MailService;
import com.systeme.fournisseur.service.StockService;

@RestController
@RequestMapping("/api/fournisseur/mail")
public class MailController {
    @Autowired
    private MailService mailService;

    @Autowired
    private StockService stockService;

    @PostMapping()
    public ResponseEntity<APIResponse> getMethodName(@RequestBody Mail mail) {
        mailService.createMail(mail);
        Mail facture = stockService.getStockDemande(mail);
        mailService.createMail(facture);
        System.out.println(facture.getListeFicheProformat().size());
        APIResponse response = null;
        if (facture != null) {
            response = new APIResponse("", facture);
            return new ResponseEntity<APIResponse>(response, HttpStatus.OK);
        } else
            return new ResponseEntity<APIResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
