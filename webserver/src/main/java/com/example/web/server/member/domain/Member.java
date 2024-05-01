package com.example.web.server.member.domain;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Member {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true)
	private String account;	//이메일

	private String password;

	private String nickname;

	private String name;

	@OneToMany(mappedBy = "member", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@Builder.Default
	private List<Authority> roles = new ArrayList<>();

	public void setRoles(List<Authority> role) {
		this.roles = role;
		role.forEach(o -> o.setMember(this));
	}

}
