package com.autfish._ehcache;

import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2017/7/19.
 */
public class EhcacheDemo {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("ehcache/applicationContext.xml");
        CacheManager cacheManager = (EhCacheCacheManager)ctx.getBean("cacheManager");
        Cache cache = cacheManager.getCache("cacheTest");

        String key = "key";
        CacheObject obj = new CacheObject(1, "an object");
        cache.put(key, obj);
        CacheObject obj2 = cache.get(key, CacheObject.class);
        System.out.println(obj2);
    }
}
