package com.acortador.controller;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acortador.Dtos.UrlDataDto;
import com.acortador.service.AddUrlDataService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/url")
public class UrlController {

    @Autowired
    private AddUrlDataService addUrlDataService;

    @PostMapping
    public ResponseEntity<Map<String, String> >createUrl(@Valid @RequestBody UrlDataDto urlDataDto) {
        String shortUrl=addUrlDataService.addUrl(urlDataDto.longUrl());
        Map<String,String> response = new HashMap<>();
        response.put("url", "http://localhost:8080/url/"+shortUrl);
        return ResponseEntity.ok(response);
    }


    @GetMapping("/{shortUrl}")
    public ResponseEntity<Void> getUrl(@PathVariable String shortUrl) {

        String longUrl= addUrlDataService.findUrl(shortUrl);

        return longUrl != null 
        ? ResponseEntity.status(HttpStatus.FOUND).location(URI.create(longUrl)).build() 
        : ResponseEntity.notFound().build();
    }
    
}
