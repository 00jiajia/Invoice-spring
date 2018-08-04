package com.test.cacheRepository;


public interface RedisRepository{
   public void set(String id,String name);
   public String get(String id);
   public void update(String id,String name);
   public void delete(String id);
}
