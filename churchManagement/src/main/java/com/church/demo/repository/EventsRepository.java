package com.church.demo.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.church.demo.entity.Events;



@Repository
public interface EventsRepository extends JpaRepository<Events,Integer>{

	@Query("from Events where eventDate >= ?1")
	public List<Events> findEventsfromCurrentDate(Date date);
}