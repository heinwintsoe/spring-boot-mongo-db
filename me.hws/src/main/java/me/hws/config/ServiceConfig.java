package me.hws.config;

import java.lang.reflect.Proxy;

import me.hws.core.repository.CategoryRepository;
import me.hws.core.service.CategoryService;
import me.hws.core.service.proxy.ServiceInvocationHandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(value = { RepositoryConfig.class })
public class ServiceConfig {

	@Autowired
	RepositoryConfig repositoryConfig;

	@Bean
	public CategoryService categoryService() throws Exception {
		CategoryService categoryService = (CategoryService) Proxy
				.newProxyInstance(CategoryService.class.getClassLoader(),
						new Class<?>[] { CategoryService.class },
						new ServiceInvocationHandler(CategoryRepository.class, (CategoryRepository) repositoryConfig.categoryRepository));
		return categoryService;
	}

}
