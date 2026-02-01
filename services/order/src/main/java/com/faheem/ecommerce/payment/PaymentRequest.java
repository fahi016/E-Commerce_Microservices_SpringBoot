package com.faheem.ecommerce.payment;

import com.faheem.ecommerce.customer.CustomerResponse;
import com.faheem.ecommerce.order.PaymentMethod;

import java.math.BigDecimal;

public record PaymentRequest(
        BigDecimal amount,
        PaymentMethod paymentMethod,
        Integer orderId,
        String orderReference,
        CustomerResponse customer
) {
}
