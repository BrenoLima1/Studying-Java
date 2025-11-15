package com.brenolima.integracao.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api")
public class ApiController {
    @GetMapping("mensagem")
    public String getMensagem() {
        return new String("Dados do Back-End Spring Boot");
    }
    
    @PostMapping("/dados")
    public String postMethodName(@RequestBody String dados) {
        
        return "Recebido: " + dados;
    }
    

}
