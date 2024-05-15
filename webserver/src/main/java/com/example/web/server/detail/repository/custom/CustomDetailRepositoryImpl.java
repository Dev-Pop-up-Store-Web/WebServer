package com.example.web.server.detail.repository.custom;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.example.web.server.detail.domain.recommendation.RecommendationPopUp;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CustomDetailRepositoryImpl implements CustomDetailRepository {

	private final MongoTemplate mongoTemplate;

	@Override
	public List<RecommendationPopUp> getPopUpMatchingHashTags(List<String> hashTags) {
		// JSON 파싱을 통한 해시태그 추출
		Gson gson = new Gson();
		JsonObject jsonObject = gson.fromJson(hashTags.get(0), JsonObject.class);

		hashTags = StreamSupport.stream(jsonObject.getAsJsonArray("hashtags").spliterator(), false)
			.map(JsonElement::getAsString)
			.collect(Collectors.toList());

		// MongoDB 쿼리 생성
		Criteria criteria = Criteria.where("hashtags").in(hashTags);
		Query query = new Query(criteria);

		// MongoDB에서 데이터 검색
		return mongoTemplate.find(query, RecommendationPopUp.class);
	}
}
