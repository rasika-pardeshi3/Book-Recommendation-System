package org.book.recommend.service;

import org.book.recommend.model.AuthorModel;
import org.book.recommend.repository.AuthorRepo;
import org.book.recommend.repository.AuthorRepoImpl;

public class AuthorServiceImpl implements AuthorService {
	AuthorRepo authRepo = new AuthorRepoImpl();

	@Override
	public boolean isAddNewAuthor(AuthorModel model) {
		// TODO Auto-generated method stub
		return authRepo.isAddNewAuthor(model);
	}

	public int getAuthorId(String authorName) {
		return authRepo.getAuthorId(authorName);
	}

}
