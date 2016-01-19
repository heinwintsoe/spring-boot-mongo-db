package me.hws.core.service;

import me.hws.core.entity.Category;
import me.hws.core.exception.ApplicationException;
import me.hws.core.repository.CategoryRepository;
import me.hws.core.service.proxy.annotation.ServiceProxy;

import org.bson.types.ObjectId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

public interface CategoryService {

	@ServiceProxy(handlerClass = CategoryRepository.class, handlerMethod = "insert")
	public Category createCategory(Category category)
			throws ApplicationException;

	@ServiceProxy(handlerClass = CategoryRepository.class, handlerMethod = "save")
	public Category updateCategory(Category category)
			throws ApplicationException;

	@ServiceProxy(handlerClass = CategoryRepository.class, handlerMethod = "delete")
	public void deleteCategory(Category category) throws ApplicationException;

	@ServiceProxy(handlerClass = CategoryRepository.class, handlerMethod = "findAll")
	public Page<Category> findCategories(Pageable pageable);

	@ServiceProxy(handlerClass = CategoryRepository.class, handlerMethod = "findById", methodParamTypes = { ObjectId.class })
	public Category findById(ObjectId id);

	@ServiceProxy(handlerClass = CategoryRepository.class, handlerMethod = "findByParent")
	public Page<Category> findByParent(PageRequest pageRequest, Category parent);

}
