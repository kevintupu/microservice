package com.kevintupu.stockservice.controller;

import com.kevintupu.stockservice.entity.StockProduct;
import com.kevintupu.stockservice.repository.StockProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stock")
public class StockController {
    private StockProductRepository stockProductRepository;

    public StockController(StockProductRepository stockProductRepository) {
        this.stockProductRepository = stockProductRepository;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProductStock(@PathVariable Long id)
    {
        StockProduct stock = stockProductRepository.findByProductId(id);
        if (stock==null)
            return new ResponseEntity<>("Product ID Not Found",HttpStatus.OK);
        return new ResponseEntity<>(stock,HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<?> postStock(@RequestBody StockProduct stock)
    {
        stockProductRepository.save(stock);

        return new ResponseEntity<>(stock,HttpStatus.CREATED);
    }
}
