package com.church.demo.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.church.demo.entity.AlterService_MemberMap;
import com.church.demo.entity.Member;
import com.church.demo.entity.Reading_MemberMap;

@Repository
public interface AlterServiceMemberMapRepository extends JpaRepository<AlterService_MemberMap, Integer> {

	@Query("from AlterService_MemberMap a inner join a.member m where a.alterServiceDate >= ?1 and m.memberId=?2")
	public List<AlterService_MemberMap> findMemberAlterServicegMapfromCurrentDate(Date date, Integer id);

}
