package com.challenge.ahorrafacil.infra.controllers;

import com.challenge.ahorrafacil.application.services.ProductService;
import com.challenge.ahorrafacil.domain.models.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{branchId}/products")
    public ResponseEntity<List<Product>> findByBranchId(@PathVariable Long branchId) {
        List<Product> result = productService.findByBranchId(branchId);
        return ResponseEntity.ok(result);
    }
}
