package com.example.web.server.member.controller.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReviewRequest {

	private Long id;

	private String account;

	private int rating;

	private String contents;

	private String popupId;

}
