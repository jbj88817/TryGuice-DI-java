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

class PriceServiceMock extends PriceServiceImpl {

    @Inject
    public PriceServiceMock(Set<String> supportedCurrencies) {
        super(supportedCurrencies);
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
//    @Inject
//    @Named("supportedCurrencies")
//    private Provider<List<String>> supportedCurrenciesProvider;


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
        orderService.sentToPayment(789L);
    }

    @Test
    public void testSupportedCurrencies() {
        throw new RuntimeException(priceService.getSupportedCurrencies().toString());
    }
}
