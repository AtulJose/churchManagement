package com.church.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.church.demo.entity.Family;
import com.church.demo.entity.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member,Integer>{

}
