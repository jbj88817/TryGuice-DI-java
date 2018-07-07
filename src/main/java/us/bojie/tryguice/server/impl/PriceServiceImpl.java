package us.bojie.tryguice.server.impl;

import java.util.Set;

import javax.inject.Inject;

import us.bojie.tryguice.server.PriceService;

public class PriceServiceImpl implements PriceService {
    private final Set<String> supportedCurrencies;

    @Inject
    public PriceServiceImpl(Set<String> supportedCurrencies) {
        this.supportedCurrencies = supportedCurrencies;
    }

    public long getPrice(long orderId) {
        return 456L;
    }

    public Set<String> getSupportedCurrencies() {
        return supportedCurrencies;
    }
}
