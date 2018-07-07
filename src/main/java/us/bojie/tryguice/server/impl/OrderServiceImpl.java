package us.bojie.tryguice.server.impl;

import javax.inject.Inject;

import us.bojie.tryguice.server.OrderService;
import us.bojie.tryguice.server.PaymentService;
import us.bojie.tryguice.server.PriceService;

public class OrderServiceImpl implements OrderService {
    private final PriceService priceService;
    @Inject private PaymentService paymentService;
    private final SessionManager sessionManager;

    private Long ordersPaid = 0L;

    @Inject
    public OrderServiceImpl(PriceService priceService,
                            SessionManager sessionManager) {
        this.priceService = priceService;
        this.sessionManager = sessionManager;
    }

    public void sentToPayment(long orderId) {
        long price = priceService.getPrice(orderId);
        paymentService.pay(orderId, price,
                sessionManager.getSessionId());
        ordersPaid = ordersPaid + 1;
    }
}
