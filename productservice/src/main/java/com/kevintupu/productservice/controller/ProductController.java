package com.kevintupu.productservice.controller;

import com.kevintupu.productservice.entity.Product;
import com.kevintupu.productservice.repository.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {
    private ProductRepository productRepository;

    public ProductController(ProductRepository productRepository)
    {
        this.productRepository = productRepository;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProductId(@PathVariable Long id)
    {
        Product product = productRepository.findById(id).orElse(null);
        if (product==null)
            return new ResponseEntity<>(HttpStatus.OK);
        return new ResponseEntity<>(product,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> postProduct(@RequestBody Product product)
    {
        productRepository.save(product);

        return new ResponseEntity<>(product,HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public  ResponseEntity<?> putProduct(@RequestBody Product product,@PathVariable Long id){
        product.setProductId(id);
        productRepository.save(product);
        return new ResponseEntity<>(product,HttpStatus.OK);

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id)
    {
        productRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
