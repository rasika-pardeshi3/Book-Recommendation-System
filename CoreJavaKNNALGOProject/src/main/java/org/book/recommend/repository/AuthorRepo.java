package org.book.recommend.repository;

import org.book.recommend.model.AuthorModel;

public interface AuthorRepo {
public boolean isAddNewAuthor(AuthorModel model);
public int getAuthorId(String authorName) ;
public boolean isAssociateAuthorBookPubCat(int catId, int pubId, boolean status, int authid);
}
