package com.acortador.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class AddUrlDataService {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;




    public void addUrl(String key, Object data) {
        try {
            redisTemplate.opsForValue().set(key, data);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void findUrl(String key) {
        try {
            redisTemplate.opsForValue().get(key);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
