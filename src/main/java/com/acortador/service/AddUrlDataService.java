package com.acortador.service;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class AddUrlDataService {
    @Autowired
    private RedisTemplate<String, String> redisTemplate;




    public String addUrl(String longUrl) {

        String shortUrl=generateShortUrl(longUrl);
        try {
            redisTemplate.opsForValue().set(shortUrl, longUrl, Duration.ofDays(1));
            return shortUrl;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public String findUrl(String shortUrl) {
        try {
           return redisTemplate.opsForValue().get(shortUrl);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public String generateShortUrl(String longUrl){
        return Integer.toHexString(longUrl.hashCode());
    }

}
