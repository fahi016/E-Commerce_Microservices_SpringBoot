package com.faheem.ecommerce.order;


import com.faheem.ecommerce.PurchaseRequest;
import com.faheem.ecommerce.customer.CustomerClient;
import com.faheem.ecommerce.exception.BusinessException;
import com.faheem.ecommerce.orderline.OrderLineRequest;
import com.faheem.ecommerce.orderline.OrderLineService;
import com.faheem.ecommerce.product.ProductClient;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.Serial;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final CustomerClient customerClient;
    private final ProductClient productClient;
    private final OrderRepository repository;
    private final OrderMapper mapper;
    private final OrderLineService orderLineService;
    public Integer createOrder(@Valid OrderRequest request) {
        //check customer --> customerFeign
        var customer = customerClient.findCustomerById(request.customerId()).orElseThrow(
                ()-> new BusinessException("Cannot create an order:: No customer exists with provided ID")
        );
        // purchase the products --> uses product micro service(Rest template)
        this.productClient.purchaseProducts(request.products());
        // persist order
        var order = this.repository.save(mapper.toOrder(request));
        // persist order lines
        for(PurchaseRequest purchaseRequest:request.products()){
                orderLineService.saveOrderLine(
                        new OrderLineRequest(
                                null,
                                order.getId(),
                                purchaseRequest.productId(),
                                purchaseRequest.quantity()
                        )
                );
        }
        //todo start payment process
        // send order conformation to notification micro service
        return null;
    }
}
