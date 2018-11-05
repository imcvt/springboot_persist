package com.imc.configuration;

import com.github.benmanes.caffeine.cache.CacheLoader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author luoly
 * @date 2018/11/5 18:58
 * @description
 */

@Configuration
public class CaffeineConfiguration {

    /**
     * 必须要指定这个Bean，refreshAfterWrite=5s这个配置属性才生效
     * @return
     */
    @Bean
    public CacheLoader<Object, Object> cacheLoader() {
        CacheLoader<Object, Object> cacheLoader = new CacheLoader<Object, Object>() {
            @Override
            public Object load(Object key) throws Exception {
                return null;
            }
            // 重写这个方法将oldValue值返回回去，进而刷新缓存
            @Override
            public Object reload(Object key, Object oldValue) throws Exception {
                System.out.println("CaffeineConfiguration reload cache ---->key:" + key + ",oldVal:" + oldValue);
                return oldValue;
            }
        };
        return cacheLoader;
    }
}
