package com.example.web.server.member.repository;

import java.util.List;

import com.example.web.server.common.repository.GenericRepository;
import com.example.web.server.member.domain.Review;

public interface ReviewRepository extends GenericRepository<Object, String> { //Object에는 Member에서 필요한 객체 넣고 String => id값
	List<Review> findByAccount(String account);
	List<Review> findByPopupId(String popupUrl);
}
