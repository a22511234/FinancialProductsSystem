package com.example.FinancialProductSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.FinancialProductSystem.entity.Product;
@Repository
public interface ProductRepo extends JpaRepository<Product,Integer>{

}
