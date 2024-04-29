package com.example.web.server.detail.repository.custom;

import java.util.List;

import com.example.web.server.detail.domain.recommendation.RecommendationPopUp;

public interface CustomDetailRepository {
	List<RecommendationPopUp> getPopUpMatchingHashTags(List<String> hashTags);
}
