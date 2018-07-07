package us.bojie.tryguice.server.impl;


import com.google.inject.Guice;

import org.junit.Test;

import us.bojie.tryguice.server.OrderService;

public class OrderServiceImplTest {

    @Test
    public void sentToPayment() {
        OrderService orderService = Guice.createInjector(new ServerModule())
                .getInstance(OrderService.class);
        orderService.sentToPayment(789L);
    }

}
