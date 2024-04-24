package com.example.web.server.detail.repository;

import org.springframework.stereotype.Repository;

import com.data.domain.PopUpStoreInfo;
import com.example.web.server.common.repository.GenericRepository;

@Repository
public interface DetailRepository extends GenericRepository<PopUpStoreInfo, String> {
}
