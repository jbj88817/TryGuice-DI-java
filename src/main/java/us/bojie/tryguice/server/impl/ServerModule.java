package us.bojie.tryguice.server.impl;

import com.google.common.base.Joiner;
import com.google.common.cache.Cache;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.TypeLiteral;
import com.google.inject.matcher.Matchers;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.lang.reflect.Method;

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

        bind(new TypeLiteral<Cache<String, String>>() {})
                .to(GuiceDemoCache.class);

        bindInterceptor(Matchers.any(),
                Matchers.annotatedWith(Logged.class),
                new MethodInterceptor() {
                    @Override
                    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
                        Method method = methodInvocation.getMethod();
                        System.out.println(String.format("Calling %s#%s(%s)",
                                method.getDeclaringClass().getName(),
                                method.getName(),
                                Joiner.on(",").join(methodInvocation.getArguments())));
                        return methodInvocation.proceed();
                    }
                });
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
