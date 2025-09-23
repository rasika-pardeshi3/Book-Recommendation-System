package org.book.recommend.service;

import org.book.recommend.model.AuthorModel;

public interface AuthorService {
public boolean isAddNewAuthor(AuthorModel model);
public int getAuthorId(String authorName);
}
