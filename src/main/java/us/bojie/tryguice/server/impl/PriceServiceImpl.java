package us.bojie.tryguice.server.impl;

import com.google.common.cache.Cache;

import java.util.Set;

import javax.inject.Inject;

import us.bojie.tryguice.server.PriceService;

public class PriceServiceImpl implements PriceService {
    private final Set<String> supportedCurrencies;
    private final Cache<String, String> cache;

    @Inject
    public PriceServiceImpl(Set<String> supportedCurrencies, Cache<String, String> cache) {
        this.supportedCurrencies = supportedCurrencies;
        this.cache = cache;
    }

    public long getPrice(long orderId) {
        throw new UnsupportedOperationException();
    }

    public Set<String> getSupportedCurrencies() {
        return supportedCurrencies;
    }

    String getCachedValue(String key) {
        return cache.getIfPresent(key);
    }
}
