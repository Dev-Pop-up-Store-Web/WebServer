package com.example.web.server.detail.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.web.server.detail.business.HashTagInfoService;
import com.example.web.server.detail.business.ImageInfoService;
import com.example.web.server.detail.business.RecommendationService;
import com.example.web.server.detail.business.TextInfoService;
import com.example.web.server.detail.domain.info.DetailInfo;
import com.example.web.server.detail.domain.recommendation.RecommendationPopUp;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class DetailPageController {

	private final TextInfoService textInfoService;
	private final ImageInfoService imageInfoService;
	private final HashTagInfoService hashTagInfoService;
	private final RecommendationService recommendationService;

	@GetMapping("/popup/{id}")
	public @ResponseBody DetailInfo getTextInfo(@PathVariable String id) {
		return textInfoService.getDetailTextInfo(id);
	}

	@GetMapping("/popup/image/{id}")
	public @ResponseBody List<String> getImageUrls(@PathVariable String id) {
		return imageInfoService.getDetailImageUrls(id);
	}

	@GetMapping("/popup/hashtag/{id}")
	public @ResponseBody List<String> getHashTags(@PathVariable String id) {
		return hashTagInfoService.getDetailHashTags(id);
	}

	@GetMapping("/popup/recommendation/{id}")
	public @ResponseBody List<RecommendationPopUp> getPopUps(@PathVariable String id) {
		return recommendationService.getDetailPopUPs(hashTagInfoService.getDetailHashTags(id));
	}
}

