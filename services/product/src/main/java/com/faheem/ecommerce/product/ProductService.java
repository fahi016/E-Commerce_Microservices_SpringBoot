package com.faheem.ecommerce.product;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    public Integer createProduct(@Valid ProdcutRequest request) {
        return  null;
    }

    public List<ProductPurchaseResponse> purchaseProducts(@Valid ProductPurchaseRequest request) {
        return null;
    }

    public ProdcuResponse findById() {
        return null;
    }

    public List<ProdcuResponse> findAll() {
        return null;
    }
}
