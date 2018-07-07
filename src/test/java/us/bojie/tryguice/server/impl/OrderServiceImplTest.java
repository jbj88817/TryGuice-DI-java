package us.bojie.tryguice.server.impl;

import com.google.inject.Guice;

import org.junit.Before;
import org.junit.Test;

import javax.inject.Inject;

import us.bojie.tryguice.server.OrderService;

public class OrderServiceImplTest {

    @Inject private OrderService orderService;

    @Before public void setUp() {
        Guice.createInjector(new ServerModule())
                .injectMembers(this);
    }

    @Test
    public void sentToPayment() {
        orderService.sentToPayment(789L);
    }

}
