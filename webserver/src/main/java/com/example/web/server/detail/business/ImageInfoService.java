package com.example.web.server.detail.business;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.web.server.detail.repository.DetailRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ImageInfoService {

	private final DetailRepository detailRepository;

	public List<String> getDetailImageUrls(String id) {
		return detailRepository.getImageUrlsById(id);
	}
}
