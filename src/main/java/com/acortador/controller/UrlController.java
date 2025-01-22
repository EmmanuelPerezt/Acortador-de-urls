package com.acortador.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acortador.Dtos.UrlDataDto;

@RestController
@RequestMapping("/url")
public class UrlController {



    @PostMapping
    public ResponseEntity<UrlDataDto> createUrl(@RequestBody UrlDataDto urlDataDto) {
        //TODO
        System.out.println("URL: " + urlDataDto.url());
        return ResponseEntity.ok(urlDataDto);
    }


    @GetMapping
    public ResponseEntity<String> getUrl() {
        //TODO
        return ResponseEntity.ok("URL");
    }
    
}
