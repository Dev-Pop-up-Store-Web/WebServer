package com.example.web.server.member.business;

import java.util.Collections;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.web.server.member.DTO.sign.SignRequest;
import com.example.web.server.member.DTO.sign.SignResponse;
import com.example.web.server.member.domain.Authority;
import com.example.web.server.member.domain.Member;
import com.example.web.server.member.repository.MemberRepository;
import com.example.web.server.member.security.JwtProvider;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SignService {

	private final MemberRepository memberRepository;
	private final PasswordEncoder passwordEncoder;
	private final JwtProvider jwtProvider;


	public SignResponse login(SignRequest request) throws Exception {
		Member member = memberRepository.findByAccount(request.getAccount()).orElseThrow(() ->
			new BadCredentialsException("잘못된 이메일 주소입니다."));

		if (!passwordEncoder.matches(request.getPassword(), member.getPassword())) {
			throw new BadCredentialsException("비밀번호가 틀렸습니다.");
		}

		return SignResponse.builder()
			.id(member.getId())
			.account(member.getAccount())
			.name(member.getName())
			.nickname(member.getNickname())
			.roles(member.getRoles())
			.token(jwtProvider.createToken(member.getAccount(), member.getRoles()))
			.build();

	}

	public boolean register(SignRequest request) throws Exception {
		try {
			Member member = Member.builder()
				.account(request.getAccount())
				.password(passwordEncoder.encode(request.getPassword()))
				.name(request.getName())
				.nickname(request.getNickname())
				.build();

			member.setRoles(Collections.singletonList(Authority.builder().name("ROLE_USER").build()));

			memberRepository.save(member);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new Exception("회원가입 할 수 없습니다");
		}
		return true;
	}

	public SignResponse getMember(String account) throws Exception {
		Member member = memberRepository.findByAccount(account)
			.orElseThrow(() -> new Exception("계정을 찾을 수 없습니다."));
		return new SignResponse(member);
	}
}
