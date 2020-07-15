package com.church.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.church.demo.entity.AlterService;
import com.church.demo.entity.Reading;


@Repository
public interface AlterServiceRepository extends JpaRepository<AlterService,Integer>{

}
