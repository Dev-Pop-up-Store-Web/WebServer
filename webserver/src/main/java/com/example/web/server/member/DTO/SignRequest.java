package com.example.web.server.member.controller.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignRequest {

	private Long id;

	private String account;

	private String password;

	private String nickname;

	private String name;

}
