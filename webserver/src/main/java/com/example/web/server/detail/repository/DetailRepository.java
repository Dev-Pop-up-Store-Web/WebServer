package com.example.web.server.detail.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.data.domain.PopUpStoreInfo;
import com.example.web.server.common.repository.GenericRepository;
import com.example.web.server.detail.domain.info.DetailInfo;

@Repository
public interface DetailRepository extends GenericRepository<PopUpStoreInfo, String> {
	@Query(value = "{'id': ?0}", fields = "{ 'urls': 1, '_id': 0}")
	List<String> getImageUrlsById(String id);

	@Query(value = "{ 'id': ?0 }", fields = "{ 'name': 1, 'startDate': 1, 'endDate': 1, "
		+ "'openTimes': 1, 'region': 1, 'address': 1, 'ticketPrice': 1, 'parkingAvailability': 1, '_id': 0}")
	DetailInfo getDetailInfoById(String id);

	@Query(value = "{'id': ?0}", fields = "{ 'hashtags': 1, '_id': 0}")
	List<String> getHashTagsById(String id);

}
