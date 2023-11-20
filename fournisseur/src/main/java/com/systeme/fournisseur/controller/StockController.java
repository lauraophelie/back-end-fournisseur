package com.systeme.fournisseur.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.systeme.fournisseur.model.Stock;
import com.systeme.fournisseur.service.StockService;

import java.util.List;

@RestController
@RequestMapping("/api/fournisseur/stockmvn spring-boot:run")
public class StockController {
    @Autowired
    private StockService uniteService;

    @GetMapping
    public List<Stock> getAllStocks() {
        return uniteService.getAllStocks();
    }

    @GetMapping("/{id}")
    public Stock getStockById(@PathVariable int id) {
        return uniteService.getStockById(id);
    }

    @PostMapping
    public Stock createStock(@RequestBody Stock unite) {
        return uniteService.createStock(unite);
    }

    @PutMapping("/{id}")
    public Stock updateUnite(@PathVariable int id, @RequestBody Stock unite) {
        unite.setId(id);
        return uniteService.updateStock(unite);
    }

    @DeleteMapping("/{id}")
    public void deleteStockById(@PathVariable int id) {
        uniteService.deleteStockById(id);
    }
}
