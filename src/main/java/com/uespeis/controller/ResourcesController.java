package com.uespeis.controller;

import java.io.IOException;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uespeis.utils.RequestReader;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin("*")
@RequestMapping(path="/resources")
public class ResourcesController {
    //TODO: IDEA: CAMBIAR EL METODO DE ABAJO Y USARLO PARA TODOS LOS RESOURCES, Y EN LA TABLA DE RESOURCES GUARDAR SOLO LOS NOMBRES
    
    @PostMapping("/get")
    public Mono<ResponseEntity<byte[]>> streamAudio(@RequestBody String mensaje) {
        var input = RequestReader.transformToMap(mensaje);
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(getByteArrayFromResource(input.get("name"))));
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
