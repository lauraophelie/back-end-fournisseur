package com.systeme.fournisseur.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.systeme.fournisseur.api.APIResponse;
import com.systeme.fournisseur.model.Mail;
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
    public List<Stock> getAllStocks() {
        return stockService.getAllStocks();
    }

    @GetMapping("/{id}")
    public Stock getStockById(@PathVariable int id) {
        return stockService.getStockById(id);
    }

    @PostMapping
    public Stock createStock(@RequestBody Stock unite) {
        return stockService.createStock(unite);
    }

    @PutMapping("/{id}")
    public Stock updateUnite(@PathVariable int id, @RequestBody Stock unite) {
        unite.setId(id);
        return stockService.updateStock(unite);
    }

    @DeleteMapping("/{id}")
    public void deleteStockById(@PathVariable int id) {
        stockService.deleteStockById(id);
    }
}
