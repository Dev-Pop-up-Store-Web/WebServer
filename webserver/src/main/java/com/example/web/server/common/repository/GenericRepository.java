package com.example.web.server.common.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface GenericRepository<T, ID> extends MongoRepository<T, ID> {
}
