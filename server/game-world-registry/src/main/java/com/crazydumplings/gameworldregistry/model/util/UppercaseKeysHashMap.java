package com.crazydumplings.gameworldregistry.model.util;

import java.util.HashMap;
import java.util.Map;

/**
 * Canse-insensitive hash map specialized for the {@link com.crazydumplings.gameworldregistry.GameWorldRegistryService game world registry}
 */
public class UppercaseKeysHashMap<V> extends HashMap<String, V> {
    @Override
    public V put(String key, V value) {
        return super.put(key.toUpperCase(), value);
    }

    @Override
    public V putIfAbsent(String key, V value) {
        return super.putIfAbsent(key.toUpperCase(), value);
    }

    @Override
    public void putAll(Map<? extends String, ? extends V> all) {
        throw new UnsupportedOperationException();
    }

    @Override
    public V get(Object key) {
        return super.get(((String) key).toUpperCase());
    }

    @Override
    public V getOrDefault(Object key, V defaultValue) {
        return super.getOrDefault(((String) key).toUpperCase(), defaultValue);
    }

    public V get(String key) {
        return this.get((Object) key);
    }

    public V getOrDefault(String key) {
        return this.getOrDefault((String) key);
    }
}
