package com.example.web.server.detail.business;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.data.domain.PopUpStoreInfo;
import com.example.web.server.detail.repository.DetailRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TextInfoService {
	private final DetailRepository detailRepository;

	public Optional<PopUpStoreInfo> getTextInfo(String id) {
		return detailRepository.findById(id);
	}
}