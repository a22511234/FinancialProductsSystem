package com.example.FinancialProductSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.FinancialProductSystem.entity.Users;
@Repository
public interface UserRepo extends JpaRepository<Users,String>{

}
