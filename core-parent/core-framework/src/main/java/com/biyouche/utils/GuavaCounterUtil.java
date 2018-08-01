package com.biyouche.utils;

import java.util.concurrent.ExecutionException;  
import java.util.concurrent.TimeUnit;  
import java.util.concurrent.atomic.AtomicLong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

/**
 * guava计数器工具类 
 *  
 * @author lgh 
 * @version 2.0 
 * @since 2018-07-26 
 * 
 */  
public class GuavaCounterUtil {  
  
    private static final Logger LOGGER = LoggerFactory.getLogger(GuavaCounterUtil.class);  
  
    private static final LoadingCache<String, AtomicLong> counter = CacheBuilder.newBuilder()
            .expireAfterWrite(2, TimeUnit.SECONDS)// 每两秒清除一次  
            .build(new CacheLoader<String, AtomicLong>() {  
                @Override  
                public AtomicLong load(String seconds) throws Exception {  
                    return new AtomicLong(0);  
                }  
            });  
  
    /** 
     * 请求是否超限 
     *  
     * @param uri 
     *            请求地址（接口地址或其他可标识字符） 
     * @param limit 
     *            每秒请求限制数 
     * @return 
     */  
    public static final boolean overLimit(String uri, long limit) {  
  
        long currentSeconds = System.currentTimeMillis() / 1000;  
        try {  
            return counter.get(uri + currentSeconds).incrementAndGet() > limit;  
        } catch (ExecutionException e) {  
            LOGGER.warn(e.getMessage(), e);  
        }  
        return false;  
    }  
  
}
