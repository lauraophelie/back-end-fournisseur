package com.systeme.fournisseur.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.systeme.fournisseur.api.APIResponse;
import com.systeme.fournisseur.model.Stock;
import com.systeme.fournisseur.service.StockService;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api/fournisseur/stock")
public class StockController {
    @Autowired
    private StockService stockService;

    @GetMapping
    public ResponseEntity<APIResponse> getAllStocks() {
        try {
            List<Stock> liste = stockService.getAllStocks();
            return new ResponseEntity<APIResponse>(new APIResponse("", liste), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<APIResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<APIResponse> getStockById(@PathVariable int id) {
        try {
            Stock liste = stockService.getStockById(id);
            return new ResponseEntity<APIResponse>(new APIResponse("", liste), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<APIResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<APIResponse> createStock(@RequestBody Stock unite) {
        try {
            Stock liste = stockService.createStock(unite);
            return new ResponseEntity<APIResponse>(new APIResponse("", liste), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<APIResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<APIResponse> updateUnite(@PathVariable int id, @RequestBody Stock unite) {
        unite.setId(id);
        try {
            Stock liste = stockService.updateStock(unite);
            return new ResponseEntity<APIResponse>(new APIResponse("", liste), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<APIResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public void deleteStockById(@PathVariable int id) {
        stockService.deleteStockById(id);
    }
}
