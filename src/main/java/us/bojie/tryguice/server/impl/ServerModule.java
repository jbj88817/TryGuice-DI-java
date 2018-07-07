package us.bojie.tryguice.server.impl;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;

import us.bojie.tryguice.server.OrderService;
import us.bojie.tryguice.server.PaymentService;
import us.bojie.tryguice.server.PriceService;

public class ServerModule extends AbstractModule {

    @Override
    protected void configure() {
        install(new ChinaModule());
        install(new GlobalModule());
        bind(OrderService.class).to(OrderServiceImpl.class);
        bind(PaymentService.class).to(PaymentServiceImpl.class);
        bind(PriceService.class).to(PriceServiceImpl.class);
//        bind(new TypeLiteral<List<String>>(){})
//                .annotatedWith(Names.named("supportedCurrencies"))
//                .toInstance(Arrays.asList("CNY", "EUR", "USD"));
    }

    @Provides
    @SessionId
    Long generateSessionId() {
        return System.currentTimeMillis();
    }

//    @Provides
//    Set<String> getSupportedCurrencies(
//            PriceService priceService) {
//        return priceService.getSupportedCurrencies();
//    }
}
