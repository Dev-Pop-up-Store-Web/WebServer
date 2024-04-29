package com.example.web.server.detail.domain.recommendation;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "infos")
public class RecommendationPopUp {
	private String name;
	private String region;
	private List<String> urls;
	// 추후 urls 제거 -> thumbnail로 교체
	private String thumbnail;
}
