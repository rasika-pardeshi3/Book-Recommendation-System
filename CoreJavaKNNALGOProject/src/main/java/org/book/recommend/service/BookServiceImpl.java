package org.book.recommend.service;

import java.util.List;

import org.book.recommend.model.BookModel;
import org.book.recommend.repository.BookRepository;
import org.book.recommend.repository.BookRepositoryImpl;

public class BookServiceImpl implements BookService {
	private BookRepository bookRepo = new BookRepositoryImpl();

	public boolean isAddNewBook(BookModel model) {

		return bookRepo.isAddNewBook(model);
	}

	@Override
	public List<BookModel> getAllBooks() {
		// TODO Auto-generated method stub
		return bookRepo.getAllBooks();
	}

	public BookModel getBookByName(String bookName) {
		return bookRepo.getBookByName(bookName);
	}
	public boolean isUpdateBook(BookModel model,String bookNameForSerach)
	{
		return bookRepo.isUpdateBook(model, bookNameForSerach);
	}

}
