package com.faheem.ecommerce.product;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository repository;
    private final ProductMapper mapper;
    public Integer createProduct(@Valid ProductRequest request) {
        var product = mapper.toProduct(request);
        return repository.save(product).getId();
    }

    public List<ProductPurchaseResponse> purchaseProducts(@Valid ProductPurchaseRequest request) {
        return null;
    }

    public ProdcutResponse findById() {
        return null;
    }

    public List<ProdcutResponse> findAll() {
        return null;
    }
}
