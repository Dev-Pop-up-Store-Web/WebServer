package com.example.web.server.detail.business;

import org.springframework.stereotype.Service;

import com.example.web.server.detail.domain.info.DetailInfo;
import com.example.web.server.detail.repository.DetailRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TextInfoService {
	private final DetailRepository detailRepository;

	public DetailInfo getDetailTextInfo(String id) {
		return detailRepository.getDetailInfoById(id);
	}
}
