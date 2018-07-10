package us.bojie.tryguice.server.impl;


import com.google.inject.Guice;
import com.google.inject.Inject;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class CacheTest {

    @Inject
    PaymentServiceImpl paymentService;

    @Inject
    PriceServiceImpl priceService;

    @Before
    public void setUp() {
        Guice.createInjector(new ServerModule())
                .injectMembers(this);
    }

    @Test
    public void testCache() {
        paymentService.putCache("testKey", "testValue");
        String cachedValue =
                priceService.getCachedValue("testKey");
        assertEquals("testValue", cachedValue);
    }

}
