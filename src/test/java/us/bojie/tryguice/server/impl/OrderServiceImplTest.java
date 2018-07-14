package us.bojie.tryguice.server.impl;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.util.Modules;

import org.junit.Before;
import org.junit.Test;

import java.util.Set;

import javax.inject.Inject;

import us.bojie.tryguice.server.OrderService;
import us.bojie.tryguice.server.PriceService;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

class PriceServiceMock extends PriceServiceImpl {

    @Inject
    public PriceServiceMock(Set<String> supportedCurrencies) {
        super(supportedCurrencies, null);
    }

    @Override
    public long getPrice(long orderId) {
        return 567L;
    }
}

public class OrderServiceImplTest {

    @Inject
    private OrderService orderService;

    @Inject
    private PriceService priceService;

    @Before
    public void setUp() {
        Guice.createInjector(Modules.override(new ServerModule()).with(
                new AbstractModule() {
                    @Override
                    protected void configure() {
                        bind(PriceService.class)
                                .to(PriceServiceMock.class);
                    }
                }))
                .injectMembers(this);
    }

    @Test
    public void sentToPayment() {
        try {
            orderService.sentToPayment(789L);
//            fail("Exception expected");
        } catch (RuntimeException e) {
            assertTrue(e.getMessage().contains("Price=567"));
            assertTrue(e.getMessage().contains("OrdersPaid=1"));
        }
    }

    @Test
    public void testSupportedCurrencies() {
        assertEquals("[CNY, EUR, USD, JPY]",
                priceService.getSupportedCurrencies()
                        .toString());
    }
}
