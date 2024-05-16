package com.example.web.server.home.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.data.domain.PopUpStoreInfo;
import com.example.web.server.home.dto.ImageListResponse;
import com.example.web.server.home.repository.HomeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class HomeService {
	private final HomeRepository infoRepository;

	@Transactional
	public List<ImageListResponse> ImageList(LocalDate date){
		List<ImageListResponse> response = new ArrayList<>();

		//LocalDate now = LocalDate.parse("2024-04-19");
		List<PopUpStoreInfo> info = infoRepository.findByDateInRange(date);

		if (!info.isEmpty()) {
			for (int i = 0 ; i < 8 ; i ++){
				ImageListResponse imageListResponse = new ImageListResponse();
				imageListResponse.setId(info.get(i).getId());
				if(imageListResponse.getUrl() != null){
					imageListResponse.setUrl(info.get(i).getUrls().get(0));
				}
				imageListResponse.setName(info.get(i).getName());
				imageListResponse.setStartDate(info.get(i).getStartDate());
				imageListResponse.setEndDate(info.get(i).getEndDate());
				imageListResponse.setAddress(info.get(i).getAddress());

				response.add(i,imageListResponse);
			}
		}

		return response;
	}
	@Transactional
	public List<ImageListResponse> SearchList(String query, String area, String date) {
		List<ImageListResponse> response = new ArrayList<>();
		List<PopUpStoreInfo> info = new ArrayList<>();
		if (!query.isEmpty() && !area.isEmpty() && !date.isEmpty()) {
			info = infoRepository.findByDateNameAndRegion(LocalDate.parse(date), query, area);
		}
		else if(query.isEmpty() && !area.isEmpty() && !date.isEmpty()){
			info = infoRepository.findByDateAndRegion(LocalDate.parse(date), area);
		}
		else if(!query.isEmpty() &&  area.isEmpty() && !date.isEmpty()){
			info = infoRepository.findByDateName(LocalDate.parse(date), query);
		}
		else if(!query.isEmpty() &&  !area.isEmpty() && date.isEmpty()){
			info = infoRepository.findByNameAndRegion(query, area);
		}
		else if(query.isEmpty() && area.isEmpty() && !date.isEmpty()){
			info = infoRepository.findByDate(LocalDate.parse(date));
		}
		else if(query.isEmpty() && !area.isEmpty() && date.isEmpty()){
			info = infoRepository.findByRegion(area);
		}
		else if(!query.isEmpty() && area.isEmpty() && date.isEmpty()){
			info = infoRepository.findByName(query);
		}



		if (!info.isEmpty()) {
			for (int i = 0 ; i < info.size() ; i ++){
				ImageListResponse imageListResponse = new ImageListResponse();
				imageListResponse.setId(info.get(i).getId());
				if(imageListResponse.getUrl() != null){
					imageListResponse.setUrl(info.get(i).getUrls().get(0));
				}
				imageListResponse.setName(info.get(i).getName());
				imageListResponse.setStartDate(info.get(i).getStartDate());
				imageListResponse.setEndDate(info.get(i).getEndDate());
				imageListResponse.setAddress(info.get(i).getAddress());

				response.add(i,imageListResponse);
			}
		}

		return response;
	}
}
