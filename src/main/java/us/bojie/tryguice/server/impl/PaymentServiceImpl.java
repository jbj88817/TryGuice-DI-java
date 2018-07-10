package us.bojie.tryguice.server.impl;

import com.google.common.cache.Cache;

import javax.inject.Inject;

import us.bojie.tryguice.server.PaymentService;

public class PaymentServiceImpl implements PaymentService {

    private final Cache<String, String> cache;

    @Inject
    public PaymentServiceImpl(Cache<String, String> cache) {
        this.cache = cache;
    }

    public void pay(long orderId, long price, Long sessionId) {

    }

    void putCache(String key, String value) {
        cache.put(key, value);
    }
}
