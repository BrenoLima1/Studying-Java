package com.example.my_first_springboot.service;

import org.springframework.stereotype.Service;
import com.example.my_first_springboot.repository.RepositoryMessage;

@Service
public class ServiceMessage {
    
    private final RepositoryMessage repositoryMessage;
    
    public ServiceMessage(RepositoryMessage repositoryMessage){
        this.repositoryMessage = repositoryMessage;
    }

    public String getMessage(){
        return repositoryMessage.getMessage();
    }
}
