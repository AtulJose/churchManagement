package com.church.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.church.demo.entity.Ward;

@Repository
public interface WardRepository extends JpaRepository<Ward,Integer>{

	
}
