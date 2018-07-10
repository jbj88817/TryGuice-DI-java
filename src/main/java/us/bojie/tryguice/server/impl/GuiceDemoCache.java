package us.bojie.tryguice.server.impl;

import com.google.common.cache.AbstractCache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.inject.Singleton;

@Singleton
public class GuiceDemoCache extends AbstractCache<String, String> {

    private final Map<String, String> keyValues = new ConcurrentHashMap<>();

    @Override
    public String getIfPresent(Object key) {
        return keyValues.get(key);
    }

    @Override
    public void put(String key, String value) {
        keyValues.put(key, value);
    }
}
