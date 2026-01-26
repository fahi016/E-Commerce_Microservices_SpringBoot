package com.faheem.ecommerce.order;


import com.faheem.ecommerce.customer.CustomerClient;
import com.faheem.ecommerce.exception.BusinessException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.Serial;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final CustomerClient customerClient;
    public Integer createOrder(@Valid OrderRequest request) {
        //check customer --> customerFeign
        var customer = customerClient.findCustomerById(request.customerId()).orElseThrow(
                ()-> new BusinessException("Cannot create an order:: No customer exixts with provided ID")
        );
        // purchase the products --> uses product micro service(Rest template)
        // persist order
        // persist order lines
        //start payment process
        // send order conformation to notification micro service
    }
}
