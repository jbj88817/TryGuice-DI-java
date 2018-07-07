package us.bojie.tryguice.server.impl;

import javax.inject.Inject;

import us.bojie.tryguice.server.OrderService;
import us.bojie.tryguice.server.PaymentService;
import us.bojie.tryguice.server.PriceService;

public class OrderServiceImpl implements OrderService {
    // Dependencies
    private final PriceService priceService;
    private final PaymentService paymentService;
    private final SessionManager sessionManager;

    // States
    private Long ordersPaid = 0L;

    @Inject
    public OrderServiceImpl(PriceService priceService,
                            PaymentService paymentService,
                            SessionManager sessionManager) {
        this.priceService = priceService;
        this.paymentService = paymentService;
        this.sessionManager = sessionManager;
    }

    public void sentToPayment(long orderId) {
        long price = priceService.getPrice(orderId);
        paymentService.pay(orderId, price,
                sessionManager.getSessionId());
        ordersPaid = ordersPaid + 1;
    }
}
