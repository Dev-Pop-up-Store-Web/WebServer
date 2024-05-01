package com.example.web.server.member.repository;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.example.web.server.common.repository.GenericRepository;
import com.example.web.server.member.domain.Member;

@Repository
public interface MemberRepository extends GenericRepository<Object, String> { //Object에는 Member에서 필요한 객체 넣고 String => id값
	Optional<Member> findByAccount(String account);
}
