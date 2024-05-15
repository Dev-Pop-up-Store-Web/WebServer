package com.example.web.server.detail.business;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.web.server.detail.domain.recommendation.RecommendationPopUp;
import com.example.web.server.detail.repository.DetailRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RecommendationService {
	private final DetailRepository detailRepository;

	public List<RecommendationPopUp> getDetailPopUPs(List<String> hashTags) {
		return detailRepository.getPopUpMatchingHashTags(hashTags);
	}
}
