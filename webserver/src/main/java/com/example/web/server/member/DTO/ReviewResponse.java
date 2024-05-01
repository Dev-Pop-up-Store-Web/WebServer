package com.example.web.server.member.controller.DTO;

import com.example.web.server.member.domain.Review;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReviewResponse {

	private Long id;

	private int rating;

	private String account;

	private String contents;

	private String popupId;

	public ReviewResponse(Review review) {
		this.id = review.getId();
		this.account = review.getAccount();
		this.contents = review.getContents();
		this.rating = review.getRating();
	}


}
