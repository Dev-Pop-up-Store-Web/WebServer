package com.example.web.server.home.repository;

import org.springframework.stereotype.Repository;

import com.data.domain.PopUpStoreInfo;
import com.example.web.server.common.repository.GenericRepository;

@Repository
public interface HomeRepository extends GenericRepository<PopUpStoreInfo, String> {
}
