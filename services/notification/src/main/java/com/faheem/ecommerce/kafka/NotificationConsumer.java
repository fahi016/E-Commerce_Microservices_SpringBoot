package com.faheem.ecommerce.kafka;

import com.faheem.ecommerce.kafka.order.OrderConfirmation;
import com.faheem.ecommerce.kafka.payment.PaymentConfirmation;
import com.faheem.ecommerce.notification.Notification;
import com.faheem.ecommerce.notification.NotificationRepository;
import com.faheem.ecommerce.notification.NotificationType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import static com.faheem.ecommerce.notification.NotificationType.ORDER_CONFIRMATION;
import static com.faheem.ecommerce.notification.NotificationType.PAYMENT_CONFIRMATION;
import static java.lang.String.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class NotificationConsumer {
     private final NotificationRepository repository;
     //private final EmailService emailService;

    @KafkaListener(topics = "payment-topic")
    public void consumePaymentSuccessNotification(PaymentConfirmation paymentConfirmation){
         log.info(format("Consuming message from payment-topic Topic:: %s",paymentConfirmation));
         repository.save(
                 Notification.builder()
                         .type(PAYMENT_CONFIRMATION)
                         .notificationDate(LocalDateTime.now())
                         .paymentConfirmation(paymentConfirmation)
                         .build()
         );

         // todo send email
    }

    @KafkaListener(topics = "order-topic")
    public void consumeOrderConfirmationNotification(OrderConfirmation orderConfirmation){
        log.info(format("Consuming message from order-topic Topic:: %s",orderConfirmation));
        repository.save(
                Notification.builder()
                        .type(ORDER_CONFIRMATION)
                        .notificationDate(LocalDateTime.now())
                        .orderConfirmation(orderConfirmation)
                        .build()
        );

        // todo send email
    }

}
