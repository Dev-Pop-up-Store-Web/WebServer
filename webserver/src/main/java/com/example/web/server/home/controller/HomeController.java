package com.example.web.server.home.controller;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.web.server.common.repository.CommonResponse;
import com.example.web.server.common.repository.StatusCode;
import com.example.web.server.home.service.HomeService;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/home")
@AllArgsConstructor // @RequiredArgsConstructor와 비교해서 신중히 고르기
public class HomeController {
	private final HomeService popUpStoreInfoService;

	@GetMapping("/get/imagelist")
	public ResponseEntity imagesList(){
		String message = "홈화면에 이미지리스트 조회를 성공했습니다.";
		LocalDate today = LocalDate.now();
		return new ResponseEntity(CommonResponse.res(true, StatusCode.OK, message,popUpStoreInfoService.ImageList(today)),null, HttpStatus.OK);
	}

	@GetMapping("/get/popup")
	public ResponseEntity imagesList(@RequestParam LocalDate date){
		String message = "날짜별 팝업 카드 결과 조회를 성공했습니다.";
		// 1. 랜덤 구현 추가 필요
		return new ResponseEntity(CommonResponse.res(true, StatusCode.OK, message,popUpStoreInfoService.ImageList(date)),null, HttpStatus.OK);
	}

	@GetMapping("/get/popup/search")
	public ResponseEntity searchList(@RequestParam String query, @RequestParam String area, @RequestParam String date){
		String message = "홈화면에 상단 검색 결과 조회를 성공했습니다.";
		// 수정 필요 (팀원들에게 묻기)
		return new ResponseEntity(CommonResponse.res(true, StatusCode.OK, message,popUpStoreInfoService.SearchList(query,area,date)),null, HttpStatus.OK);
	}
}
