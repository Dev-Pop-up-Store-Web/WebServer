package com.example.web.server.home.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.data.domain.PopUpStoreInfo;
import com.example.web.server.common.repository.GenericRepository;

@Repository
public interface HomeRepository extends GenericRepository<PopUpStoreInfo, String> {
	@Query("{ 'startDate': { '$lte': ?0 }, 'endDate': { '$gte': ?0 } }")
	List<PopUpStoreInfo> findByDateInRange(LocalDate date);

	@Query("{$or: [" +
		"{'name': {$regex: ?1, $options: 'i'}}, " + // Case-insensitive match of 'query' within 'name'
		"{'region': {$eq: ?2}}, " +
		"{'startDate': {$lte: ?0}}, " +
		"{'endDate': {$gte: ?0}}]}")
	List<PopUpStoreInfo> findByDateNameAndRegion(LocalDate date, String query, String area);

	@Query("{$or: [" +
		"{'region': {$eq: ?1}}, " +
		"{'startDate': {$lte: ?0}}, " +
		"{'endDate': {$gte: ?0}}]}")
	List<PopUpStoreInfo> findByDateAndRegion(LocalDate date,  String area);

	@Query("{$or: [" +
		"{'name': {$regex: ?1, $options: 'i'}}, " + // Case-insensitive match of 'query' within 'name'
		"{'startDate': {$lte: ?0}}, " +
		"{'endDate': {$gte: ?0}}]}")
	List<PopUpStoreInfo> findByDateName(LocalDate date, String query);

	@Query("{$or: [" +
		"{'name': {$regex: ?0, $options: 'i'}}, " + // Case-insensitive match of 'query' within 'name'
		"{'region': {$eq: ?1}}]}" )
	List<PopUpStoreInfo> findByNameAndRegion(String query, String area);

	@Query("{$or: [" +
		"{'startDate': {$lte: ?0}}, " +
		"{'endDate': {$gte: ?0}}]}")
	List<PopUpStoreInfo> findByDate(LocalDate date);

	@Query("{$or: [" +
		"{'region': {$eq: ?0}}]}")
	List<PopUpStoreInfo> findByRegion(String area);

	@Query("{$or: [" +
		"{'name': {$regex: ?0, $options: 'i'}}]}") // Case-insensitive match of 'query' within 'name'
	List<PopUpStoreInfo> findByName(String query);
}
