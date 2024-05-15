package com.example.web.server.home.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class ImageListResponse {
	private String id;
	private String url;
	private String name;
	private LocalDate startDate;
	private LocalDate endDate;
	private String address;
}
