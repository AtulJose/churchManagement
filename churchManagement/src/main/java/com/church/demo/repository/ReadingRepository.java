package com.church.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.church.demo.entity.Reading;


@Repository
public interface ReadingRepository extends JpaRepository<Reading,Integer>{

}
