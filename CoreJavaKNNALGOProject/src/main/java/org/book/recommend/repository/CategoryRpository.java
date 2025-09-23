package org.book.recommend.repository;

import java.util.List;

import org.book.recommend.model.CategoryModel;

public interface CategoryRpository {
	public boolean isAddNewCategory(CategoryModel model);
	public List<CategoryModel> getAllCategories();

}
