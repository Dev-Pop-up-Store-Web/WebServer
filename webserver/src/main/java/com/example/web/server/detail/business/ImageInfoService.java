package com.example.web.server.detail.business;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.data.domain.PopUpStoreInfo;
import com.example.web.server.detail.repository.DetailRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ImageInfoService {

	private final DetailRepository detailRepository;

	public List<String> getImageInfo(String id) {
		Optional<PopUpStoreInfo> data = detailRepository.findById(id);
		return Objects.requireNonNull(data.orElse(null)).getUrls();
	}
}
