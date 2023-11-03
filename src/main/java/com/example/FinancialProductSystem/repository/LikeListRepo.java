package com.example.FinancialProductSystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.FinancialProductSystem.entity.LikeList;

public interface LikeListRepo extends JpaRepository<LikeList, Integer> {
	
	@Query(value="SELECT * FROM likelists t WHERE t.UserID =: userID ORDER BY t.ProductID ASC",nativeQuery=true)
	public List<LikeList> getUserLikelist(String userID);
}
