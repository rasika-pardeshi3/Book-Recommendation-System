package org.book.recommend.service;

import java.util.List;

import org.book.recommend.model.CategoryModel;
import org.book.recommend.repository.CategoryRepositoryImpl;

public class CategoryServiceImpl implements CategoryService{
	CategoryRepositoryImpl catRepo=new CategoryRepositoryImpl();

	@Override
	public boolean isAddNewCategory(CategoryModel model) {
		// TODO Auto-generated method stub
		return catRepo.isAddNewCategory(model) ;
	}

	@Override
	public List<CategoryModel> getAllCategories() {
		
		return catRepo.getAllCategories();
	}

}
