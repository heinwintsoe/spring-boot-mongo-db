package me.hws.web.controller;

import java.util.ArrayList;
import java.util.List;

import me.hws.core.entity.Category;
import me.hws.core.exception.ApplicationException;
import me.hws.core.repository.CategoryRepository;
import me.hws.core.service.CategoryService;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/category")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private CategoryRepository categoryRepository;

	@RequestMapping(value="/", method=RequestMethod.GET)
	public String createCategory(Model model) {
		String page = "category/create-category";
		return page;
	}
	
	@RequestMapping(value="/save", method=RequestMethod.GET)
	public String saveCategory(Model model) throws ApplicationException {
		Category category = new Category();
		category.setName("Category C");
		category.setDescription("Description of Category C");
		
		List<Category> children = new ArrayList<Category>();
		Category child = new Category();
		child.setName("Category C.A");
		child.setDescription("Description of Category C.A");
		children.add(child);
		
		child = new Category();
		child.setName("Category C.B");
		child.setDescription("Description of Category C.B");
		children.add(child);
		
		child = new Category();
		child.setName("Category C.C");
		child.setDescription("Description of Category C.C");
		children.add(child);
		
		
		categoryService.createCategory(category);
		System.out.println("Category was saved.");
		
		
		return null;
	}
	
	@RequestMapping(value="/find", method=RequestMethod.GET)
	public String findCategory() {
		Category result = categoryService.findById(new ObjectId("569ca5281a123bdd66f9903f"));
		System.out.println(result);
		
		
		System.out.println("Controller Ended");
		return null;
	}
	
}
