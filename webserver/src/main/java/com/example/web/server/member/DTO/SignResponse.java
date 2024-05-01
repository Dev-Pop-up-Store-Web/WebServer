package com.example.web.server.member.DTO;

import java.util.ArrayList;
import java.util.List;

import com.example.web.server.member.domain.Authority;
import com.example.web.server.member.domain.Member;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SignResponse {

	private Long id;

	private String account;

	private String nickname;

	private String name;

	private List<Authority> roles = new ArrayList<>();

	private String token;

	public SignResponse(Member member) {
		this.id = member.getId();
		this.account = member.getAccount();
		this.nickname = member.getNickname();
		this.name = member.getName();
		this.roles = member.getRoles();
	}
}
