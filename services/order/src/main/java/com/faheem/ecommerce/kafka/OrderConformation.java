package com.faheem.ecommerce.kafka;

import com.faheem.ecommerce.customer.CustomerResponse;
import com.faheem.ecommerce.order.PaymentMethod;
import com.faheem.ecommerce.product.PurchaseResponse;

import java.math.BigDecimal;
import java.util.List;

public record OrderConformation(
        String orderReference,

        BigDecimal totalAmount,

        PaymentMethod paymentMethod,

        CustomerResponse customer,

        List<PurchaseResponse> products


) {

}
