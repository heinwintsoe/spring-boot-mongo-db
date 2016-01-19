package me.hws.config;

import me.hws.core.repository.CategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages={"me.hws.core.repository"})
@Import(MongoConfig.class)
public class RepositoryConfig {
	
	@Autowired MongoConfig mongoConfig;
	
	@Autowired CategoryRepository categoryRepository;
	
}
