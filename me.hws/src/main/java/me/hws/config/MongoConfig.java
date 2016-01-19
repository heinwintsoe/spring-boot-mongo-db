package me.hws.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import com.mongodb.MongoClient;

@Configuration
public class MongoConfig {
	
	private static final String DB_NAME = "simple_issues";
	private static final String DB_HOST = "127.0.0.1";
	
	@Bean
	public MongoDbFactory mongoDbFactory() throws Exception {
		return new SimpleMongoDbFactory(new MongoClient(DB_HOST), DB_NAME);
	}

	@Bean
	public MongoTemplate mongoTemplate() throws Exception {		
		MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory());				
		return mongoTemplate;		
	}


}
