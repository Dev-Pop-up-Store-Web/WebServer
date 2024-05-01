package com.example.web.server.member.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.web.server.member.DTO.ReviewRequest;
import com.example.web.server.member.DTO.ReviewResponse;
import com.example.web.server.member.domain.Review;
import com.example.web.server.member.repository.MemberRepository;
import com.example.web.server.member.repository.ReviewRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReviewService {

	private final ReviewRepository reviewRepository;
	private final MemberRepository memberRepository;

	public boolean addReview(ReviewRequest request) throws Exception {
		// 회원 정보가 존재하지 않는다면
		if (memberRepository.findByAccount(request.getAccount()).equals(Optional.empty())) {
			throw new Exception("회원가입이 필요합니다.");
		}
		try {
			Review review = Review.builder()
				.account(request.getAccount())
				.rating(request.getRating())
				.contents(request.getContents())
				.popupId(request.getPopupId())
				.build();

			reviewRepository.save(review);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new Exception("후기를 추가할 수 없습니다.");
		}
		return true;
	}

	public List<ReviewResponse> getReviewByUser(String account) throws Exception {
		List<Review> reviews = reviewRepository.findByAccount(account);
		if (reviews.isEmpty()) {
			throw new Exception("작성한 후기가 존재하지 않습니다.");
		}
		return reviews.stream()
			.map(ReviewResponse::new)
			.collect(Collectors.toList());
	}

	public List<ReviewResponse> getReviewById(String popupId) throws Exception{
		List<Review> reviews = reviewRepository.findByPopupId(popupId);
		if (reviews.isEmpty()) {
			throw new Exception("해당 팝업에 대한 후기가 존재하지 않습니다.");
		}
		return reviews.stream()
			.map(ReviewResponse::new)
			.collect(Collectors.toList());
	}
}

