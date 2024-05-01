package com.example.web.server.member.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.web.server.member.domain.Member;
import com.example.web.server.member.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class JpaUserDetailsService implements UserDetailsService {

	private final MemberRepository memberRepository;

	@Override
	public UserDetails loadUserByUsername(String userAccount) throws UsernameNotFoundException {
		Member member = memberRepository.findByAccount(userAccount).orElseThrow(
			() -> new UsernameNotFoundException("Invalid authentication!")
		);

		return new CustomUserDetails(member);
	}
}
