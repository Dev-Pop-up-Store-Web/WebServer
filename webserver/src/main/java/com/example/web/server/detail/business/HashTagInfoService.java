package com.example.web.server.detail.business;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.web.server.detail.repository.DetailRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class HashTagInfoService {
	private final DetailRepository detailRepository;

	public List<String> getDetailHashTags(String id) {
		return detailRepository.getHashTagsById(id);
	}

}
