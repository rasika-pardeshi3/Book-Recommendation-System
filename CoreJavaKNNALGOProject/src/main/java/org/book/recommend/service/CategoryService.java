package org.book.recommend.service;

import java.util.List;

import org.book.recommend.model.CategoryModel;

public interface CategoryService {
	public boolean isAddNewCategory(CategoryModel model);
	public List<CategoryModel> getAllCategories();

}
