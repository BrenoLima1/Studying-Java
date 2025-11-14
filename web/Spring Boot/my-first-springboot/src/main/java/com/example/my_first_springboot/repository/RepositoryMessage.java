package com.example.my_first_springboot.repository;

import org.springframework.stereotype.Repository;

@Repository
public class RepositoryMessage {
    
    public String getMessage(){
        return "Welcome from the Repository";
    }
}
