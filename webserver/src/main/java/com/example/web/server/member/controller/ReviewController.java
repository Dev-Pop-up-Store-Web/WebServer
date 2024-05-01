package com.example.web.server.member.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.web.server.member.DTO.ReviewRequest;
import com.example.web.server.member.service.ReviewService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/review")
public class ReviewController {

	private final ReviewService reviewService;

	// 후기 작성
	@PostMapping(value = "/register")
	public ResponseEntity<Boolean> addReview(@RequestBody ReviewRequest request) throws Exception {
		log.info("Received request to add review: {}", request);
		return new ResponseEntity<>(reviewService.addReview(request), HttpStatus.OK);
	}

}

