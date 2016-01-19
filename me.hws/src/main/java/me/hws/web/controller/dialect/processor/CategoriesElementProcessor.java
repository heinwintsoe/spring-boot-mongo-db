package me.hws.web.controller.dialect.processor;

import java.util.List;

import me.hws.config.MongoConfig;
import me.hws.config.RepositoryConfig;
import me.hws.config.ServiceConfig;
import me.hws.core.entity.Category;
import me.hws.core.service.CategoryService;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.thymeleaf.Arguments;
import org.thymeleaf.dom.Element;
import org.thymeleaf.dom.Node;
import org.thymeleaf.processor.element.AbstractMarkupSubstitutionElementProcessor;

public class CategoriesElementProcessor extends
		AbstractMarkupSubstitutionElementProcessor {

	public CategoriesElementProcessor() {
		super("categories");
	}

	@Override
	protected List<Node> getMarkupSubstitutes(final Arguments arguments, final Element element) {
		
		ApplicationContext appCtx = new AnnotationConfigApplicationContext(MongoConfig.class, RepositoryConfig.class, ServiceConfig.class);
		CategoryService categoryService = (CategoryService) appCtx
				.getBean("categoryService");
		
		int itemsOnPage = Integer.parseInt(element.getAttributeValue("itemsOnPage"));
		System.out.println("Item On Page: " + itemsOnPage);
		String styleClass = element.getAttributeValue("class");
		System.out.println("Style Class: " + styleClass);
		
		PageRequest pageRequest = new PageRequest(0, itemsOnPage);
		Page<Category> page = categoryService.findCategories(pageRequest);
		for(Category category : page.getContent()) {
			System.out.println(" Category Name: " + category.getName() 
					+ " Category Description: " + category.getDescription()
					+ " Category Id: " + category.getId());
		}
		
		return null;
	}

	@Override
	public int getPrecedence() {
		return 1000;
	}

}
