package com.faheem.ecommerce.product;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService service;

    @PostMapping
    public ResponseEntity<Integer> createProduct(
            @RequestBody @Valid ProdcutRequest request
    ){
        return ResponseEntity.ok(service.createProduct(request));

    }

    @PostMapping("/products")
    public ResponseEntity<List<ProductPurchaseResponse>> purchaseProducts(
            @RequestBody @Valid ProductPurchaseRequest request
    ){
        return ResponseEntity.ok(service.purchaseProducts(request));
    }

    @GetMapping("/{product-id}")
    public ResponseEntity<ProdcuResponse> findById(
            @PathVariable("product-id") Integer productId
    ){
        return ResponseEntity.ok(service.findById());
    }

    @GetMapping
    public ResponseEntity<List<ProdcuResponse>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }
}
