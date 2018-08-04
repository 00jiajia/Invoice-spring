//package com.test.cacheRepository;
//
//import net.sf.ehcache.Cache;
//import net.sf.ehcache.CacheManager;
//import net.sf.ehcache.Element;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class CacheImpl implements CacheRepository{
//
//    CacheManager cm=CacheManager.getInstance();
//    Cache cache;
//    public CacheImpl(){
//        cm.addCache("temp");
//        cache=cm.getCache("temp");
//    }
//
//    @Override
//    public void put(String key, Object o) {
//        cache.put(new Element(key,o));
//    }
//
//    @Override
//    public List getList(String key) {
//        return null;
//    }
//
//    @Override
//    public Object get(String key) {
//        return cache.get(key).getObjectValue();
//    }
//
//    @Override
//    public void clearn(String key) {
//        cache.remove(key);
//    }
//
//    @Override
//    public void close() {
//        cm.shutdown();
//    }
//
//    @Override
//    public void clearAll() {
//        cache.removeAll();
//    }
//
//}
//
