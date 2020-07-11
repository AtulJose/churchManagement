package com.church.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.church.demo.entity.Family;


@Repository
public interface FamilyRepository extends JpaRepository<Family,Integer>{

		@Query("from Family where userId = ?1 and password = ?2")
		Family findByUserIdAndPassword(String userId, String password);
		
		
}
