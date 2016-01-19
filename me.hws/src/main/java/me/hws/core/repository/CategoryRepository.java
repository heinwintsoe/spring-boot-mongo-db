package me.hws.core.repository;

import me.hws.core.entity.Category;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CategoryRepository extends MongoRepository<Category, Long> {

	public Category findById(ObjectId id);
	
}
