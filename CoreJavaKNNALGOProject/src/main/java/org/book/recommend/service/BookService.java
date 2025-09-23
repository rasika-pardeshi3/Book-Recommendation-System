package org.book.recommend.service;

import java.util.List;

import org.book.recommend.model.BookModel;

public interface BookService {
	public boolean isAddNewBook(BookModel model);

	public List<BookModel> getAllBooks();

	public BookModel getBookByName(String bookName);

	public boolean isUpdateBook(BookModel model, String bookNameForSerach);
}
