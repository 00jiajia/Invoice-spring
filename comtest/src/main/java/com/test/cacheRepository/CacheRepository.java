package com.test.cacheRepository;

import java.util.List;

public interface CacheRepository<T> {
    void put(String key,T t);
    List<T> getList(String key);
    T get(String key);
    void clearn(String key);
    void close();
    void clearAll();
}
