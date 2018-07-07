package us.bojie.tryguice.server.impl;

import com.google.inject.Guice;

import org.junit.Before;
import org.junit.Test;

import javax.inject.Inject;

import us.bojie.tryguice.server.OrderService;
import us.bojie.tryguice.server.PriceService;

public class OrderServiceImplTest {

    @Inject
    private OrderService orderService;

    @Inject
    private PriceService priceService;
//    @Inject
//    @Named("supportedCurrencies")
//    private Provider<List<String>> supportedCurrenciesProvider;



    @Before
    public void setUp() {
        Guice.createInjector(new ServerModule())
                .injectMembers(this);
    }

    @Test
    public void sentToPayment() {
        orderService.sentToPayment(789L);
    }

    @Test
    public void testSupportedCurrencies() {
        throw new RuntimeException(priceService.getSupportedCurrencies().toString());
    }
}
