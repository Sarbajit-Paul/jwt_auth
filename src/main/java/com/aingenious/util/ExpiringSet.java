package com.aingenious.util;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.util.concurrent.TimeUnit;

public class ExpiringSet<T> {
    private final Cache<T, Boolean> cache;

    public ExpiringSet(long duration, TimeUnit timeUnit) {
        cache = CacheBuilder.newBuilder()
                .expireAfterWrite(duration, timeUnit)
                .build();
    }

    public void add(T item) {
        cache.put(item, Boolean.TRUE);
    }

    public boolean contains(T item) {
        return cache.getIfPresent(item) != null;
    }

    public void remove(T item) {
        cache.invalidate(item);
    }

    public long size() {
        return cache.size();
    }

    // Other set operations can be added as needed
}

