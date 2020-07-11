package com.church.demo.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.church.demo.entity.Member;
import com.church.demo.entity.Reading_MemberMap;

@Repository
public interface ReadingMemberMapRepository extends JpaRepository<Reading_MemberMap,Integer>{
	
	@Query("from Reading_MemberMap r JOIN Member m where r.readingDate >= ?1 AND m.memberId=?2")
	public List<Reading_MemberMap> findMemberReadingMapfromCurrentDate(Date date,Integer id);

}
