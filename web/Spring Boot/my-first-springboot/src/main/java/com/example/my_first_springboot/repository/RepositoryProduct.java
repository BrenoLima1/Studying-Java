package com.example.my_first_springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.my_first_springboot.model.Product;

@Repository
public interface RepositoryProduct extends JpaRepository<Product, Long> {

    
} 