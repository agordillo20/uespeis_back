package com.uespeis.controller;

import java.io.IOException;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin("*")
@RequestMapping(path="/resources")
public class ResourcesController {
    
    @GetMapping("/audio/{name}")
    public Mono<ResponseEntity<byte[]>> streamAudio(@PathVariable("name") String name) {
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(getByteArrayFromResource(name)));
    }
  
    private byte[] getByteArrayFromResource(final String name) {
        try {
            return new ClassPathResource(name).getContentAsByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
