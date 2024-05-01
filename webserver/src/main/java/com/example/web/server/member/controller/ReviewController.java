package com.example.web.server.member.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.web.server.member.DTO.review.ReviewRequest;
import com.example.web.server.member.DTO.review.ReviewResponse;
import com.example.web.server.member.business.ReviewService;

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

	// 사용자별 후기 조회
	@GetMapping("/member")
	public ResponseEntity<List<ReviewResponse>> getReview(@RequestParam String account) throws Exception {
		log.info("Received request to get review by user account");
		return new ResponseEntity<>( reviewService.getReviewByUser(account), HttpStatus.OK);
	}

	// 팝업별 후기 조회
	@GetMapping("/popup")
	public ResponseEntity<List<ReviewResponse>> getReviewById(@RequestParam String popupId) throws Exception {
		log.info("Received request to get review by popup id");
		return new ResponseEntity<>( reviewService.getReviewById(popupId), HttpStatus.OK);
	}

}

