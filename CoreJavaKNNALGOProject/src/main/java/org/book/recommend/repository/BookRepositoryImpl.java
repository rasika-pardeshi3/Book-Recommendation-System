package org.book.recommend.repository;

import java.sql.Date;
import java.util.List;
import java.util.*;

import org.book.recommend.config.DBConfig;
import org.book.recommend.model.BookModel;

public class BookRepositoryImpl extends DBConfig implements BookRepository {
	List<BookModel> bookList;

	@Override
	public boolean isAddNewBook(BookModel model) {
		try {
			stmt = conn.prepareStatement("insert into book values('0',?,?,?,?)");
			stmt.setString(1, model.getName());
			stmt.setFloat(2, model.getBprice());
			stmt.setDate(3, java.sql.Date.valueOf(model.getPyear()));
			stmt.setString(4, model.getBriefDesc());
			int value = stmt.executeUpdate();
			if (value > 0) {
				return true;
			} else {
				return false;
			}
		} catch (Exception ex) {
			System.out.println("Error is " + ex);
			return false;
		}
	}

	@Override
	public List<BookModel> getAllBooks() {
		try {
			bookList = new ArrayList<BookModel>();
			stmt = conn.prepareStatement("select * from book");
			rs = stmt.executeQuery();
			while (rs.next()) {
				BookModel bookModel = new BookModel(rs.getInt(1), rs.getString(2), rs.getFloat(3), rs.getString(4),
						rs.getString(5));
				bookList.add(bookModel);
			}
			return bookList.size() > 0 ? bookList : null;
		} catch (Exception ex) {
			System.out.println("Error is" + ex);
		}
		return null;
	}

	public BookModel getBookByName(String bookName) {
		try {
			stmt = conn.prepareStatement("select * from book where bname=?");
			stmt.setString(1, bookName);
			rs = stmt.executeQuery();
			BookModel b = null;
			if (rs.next()) {
				b = new BookModel(rs.getInt(1), rs.getString(2), rs.getFloat(3), rs.getString(4), rs.getString(5));
			}
			return b;
		} catch (Exception ex) {
			System.out.println("Error is " + ex);
			return null;
		}
	}

	public boolean isUpdateBook(BookModel model, String bookNameForSerach) {
		try {
			stmt = conn.prepareStatement("update book set bname=?, price=?, pyear=?, briefdesc=? where bname");
			stmt.setString(1, model.getName());
			stmt.setFloat(2, model.getBprice());
			stmt.setDate(3, java.sql.Date.valueOf(model.getPyear()));
			stmt.setString(4, model.getBriefDesc());
			stmt.setString(5, bookNameForSerach);
			int value = stmt.executeUpdate();
			if (value > 0) {
				return true;
			} else {
				return false;
			}
		} catch (Exception ex) {

		}
		return false;
	}
}
