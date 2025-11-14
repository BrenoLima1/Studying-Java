package com.example.my_first_springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.my_first_springboot.service.ServiceMessage;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/api")
public class MessageController {
    
    private final ServiceMessage serviceMessage;
    public MessageController(ServiceMessage serviceMessage) {
        this.serviceMessage = serviceMessage;
    }

    @GetMapping("/message")
    public String getMethodName() {
        return serviceMessage.getMessage();
    }
    

}
