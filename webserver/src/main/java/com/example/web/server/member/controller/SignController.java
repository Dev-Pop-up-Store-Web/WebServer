package com.example.web.server.member.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.web.server.member.DTO.SignRequest;
import com.example.web.server.member.DTO.SignResponse;
import com.example.web.server.member.service.SignService;

import lombok.RequiredArgsConstructor;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@Slf4j
public class SignController {

	private final SignService memberService;

	// 로그인
	@PostMapping(value = "/login")
	public ResponseEntity<SignResponse> signin(@RequestBody SignRequest request) throws Exception {
		log.info("Received request to sign in: {}", request);
		return new ResponseEntity<>(memberService.login(request), HttpStatus.OK);
	}

	// 회원가입
	@PostMapping(value = "/register")
	public ResponseEntity<Boolean> signup(@RequestBody SignRequest request) throws Exception {
		log.info("Received request to sign up: {}", request);
		return new ResponseEntity<>(memberService.register(request), HttpStatus.OK);
	}

}
