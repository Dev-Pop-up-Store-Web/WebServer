package com.example.web.server.detail.business;

import org.springframework.stereotype.Service;

import com.example.web.server.detail.repository.DetailRepository;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class TextInfoService {

	private final DetailRepository detailRepository;

	@PostConstruct
	public void getData() {

	}

}
