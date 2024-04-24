package com.example.web.server.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

// basePackages = {"com.example.web.server.detail.repository1", "com.example.web.server.detail.repository2"} 이런식으로 추가
@EnableMongoRepositories(basePackages = {"com.example.web.server.detail.repository",
	"com.example.web.server.home.repository"})
@Configuration
public class MongoConfig {
	@Value("${spring.data.mongodb.host}")
	private String mongoHost;

	@Value("${spring.data.mongodb.port}")
	private int mongoPort;

	@Value("${spring.data.mongodb.database}")
	private String databaseName;

	@Bean
	public MongoClient mongoClient() {
		return MongoClients.create(String.format("mongodb://%s:%d", mongoHost, mongoPort));
	}

	@Bean
	public MongoTemplate mongoTemplate() {
		return new MongoTemplate(mongoClient(), databaseName);
	}
}
